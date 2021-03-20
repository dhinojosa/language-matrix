package com.evolutionnext.httpclient;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.reactivex.rxjava3.core.Flowable;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import java.io.IOException;
import java.net.*;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.security.NoSuchAlgorithmException;
import java.time.Duration;
import java.util.Base64;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Flow;

import org.reactivestreams.FlowAdapters;

import javax.net.ssl.SSLContext;

public class HttpClientTest {
    
    @Test
    @DisplayName("Run an example connecting to a simple" +
        " web endpoint using GET and returning a String")
    void testSimpleGet() throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request =
            HttpRequest
                .newBuilder()
                .uri(URI.create("http://localhost:8080/hello"))
                .build();

        HttpResponse<String> response = client.send(request,
            HttpResponse.BodyHandlers.ofString());

        System.out.println(response.body());
    }

    @Test
    @DisplayName("Run an example connecting to a simple" +
        " web endpoint using GET asynchronously and returning a String")
    void testSimpleAsyncGet() throws InterruptedException {
        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request =
            HttpRequest
                .newBuilder()
                .uri(URI.create("http://localhost:8080/hello"))
                .build();

        CompletableFuture<HttpResponse<String>> future =
            client.sendAsync(request,
                HttpResponse.BodyHandlers.ofString());

        future
            .thenApply(HttpResponse::body)
            .thenAccept(System.out::println);

        Thread.sleep(1000);
    }


    private static List<Fruit> uncheckedGetFruit(ObjectMapper mapper,
                                                 String s) {
        try {
            return mapper.readValue(s, new TypeReference<>() {
            });
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void testGetWithJson() throws InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        ObjectMapper mapper = new ObjectMapper();

        HttpRequest request =
            HttpRequest
                .newBuilder()
                .uri(URI.create("http://localhost:8080/fruits"))
                .build();

        client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
              .thenApply(HttpResponse::body)
              .thenApply(s -> uncheckedGetFruit(mapper, s))
              .exceptionally(t -> List.of())
              .thenAccept(System.out::println);
        Thread.sleep(2000);
    }

    @Test
    void testPostWithJSON() throws JsonProcessingException,
        InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        ObjectMapper mapper = new ObjectMapper();

        Fruit watermelon = new Fruit("Watermelon", "Delicious Summer Treat");

        String body = mapper.writeValueAsString(watermelon);

        HttpRequest request =
            HttpRequest
                .newBuilder()
                .header("content-type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(body))
                .uri(URI.create("http://localhost:8080/fruits"))
                .build();

        client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
              .thenApply(HttpResponse::body)
              .thenApply(s -> uncheckedGetFruit(mapper, s))
              .exceptionally(t -> {
                  t.printStackTrace();
                  return List.of();
              })
              .thenAccept(System.out::println);
        Thread.sleep(2000);
    }

    @Test
    void testPostWithJSONWithPairStatusAndContent() throws JsonProcessingException,
        InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        ObjectMapper mapper = new ObjectMapper();

        Fruit watermelon = new Fruit("Cantaloupe", "Nice, Juicy");

        String body = mapper.writeValueAsString(watermelon);

        HttpRequest request =
            HttpRequest
                .newBuilder()
                .header("content-type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(body))
                .uri(URI.create("http://localhost:8080/fruits"))
                .build();

        CompletableFuture<HttpResponse<String>> resp =
            client.sendAsync(request, HttpResponse.BodyHandlers.ofString());

        CompletableFuture<Integer> statusCode =
            resp.thenApply(HttpResponse::statusCode);

        CompletableFuture<String> content =
            resp.thenApply(HttpResponse::body);

        CompletableFuture<Pair<Integer, List<Fruit>>> pairCompletableFuture =
            statusCode.thenCompose(sc ->
                content.thenApply(b -> new Pair<>(sc
                    , uncheckedGetFruit(mapper, b))));

        CompletableFuture<Pair<Integer, List<Fruit>>> exceptionally =
            pairCompletableFuture.exceptionally(t -> new Pair<>(100,
                List.of()));

        exceptionally.thenAccept(System.out::println);

        Thread.sleep(2000);
    }

    //TODO: A benefit of using a Publisher is taking content
    //      and forking and being able to dispose of a Flowable
    //      Publishers are also standards and can be plugged into
    //      your favorite
    @Test
    void testPostWithJSONWithPublisherAPI() throws JsonProcessingException,
        InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        ObjectMapper mapper = new ObjectMapper();

        Fruit watermelon = new Fruit("Tangelo", "What the **** is this thing?");

        String body = mapper.writeValueAsString(watermelon);

        HttpRequest request =
            HttpRequest
                .newBuilder()
                .header("content-type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(body))
                .uri(URI.create("http://localhost:8080/fruits"))
                .build();

        CompletableFuture<HttpResponse<Flow.Publisher<List<ByteBuffer>>>> future =
            client.sendAsync(request, HttpResponse.BodyHandlers.ofPublisher());

        future
            .thenApply(resp -> {
                Flow.Publisher<List<ByteBuffer>> body1 = resp.body();
                return FlowAdapters.toPublisher(body1);
            })
            .thenApply(Flowable::fromPublisher)
            .thenApply(flowable ->
                flowable.flatMap(Flowable::fromIterable))
            .thenApply(flowable ->
                flowable.map(bb -> StandardCharsets.UTF_8.decode(bb).toString()))
            .thenApply(flowable ->
                flowable.flatMap(s -> Flowable.fromIterable(uncheckedGetFruit(mapper, s))))
            .thenApply(flowable ->
                flowable.subscribe(System.out::println,
                    Throwable::printStackTrace))
            .thenAccept(disposable -> {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                disposable.dispose();
            });
        Thread.sleep(3000);
    }

    @SuppressWarnings("StringBufferReplaceableByString")
    @Test
    void testBasicAuthentication() throws InterruptedException {

        String username = "user";
        String password = "user";

        StringBuilder builder = new StringBuilder();
        builder.append(username);
        builder.append(":");
        builder.append(password);

        Base64.Encoder encoder = Base64.getEncoder();
        HttpRequest request =
            HttpRequest
                .newBuilder()
                .timeout(Duration.ofMinutes(2))
                .uri(URI.create("http://localhost:8080/api/users/me"))
                .header("Authorization", "Basic " +
                    encoder.encodeToString(builder.toString().getBytes()))
                .build();

        HttpClient
            .newHttpClient()
            .sendAsync(request, HttpResponse.BodyHandlers.ofString())
            .thenApply(resp -> new Pair<>(resp.statusCode(), resp.body()))
            .thenAccept(System.out::println);

        Thread.sleep(2000);
    }

    @Test
    void testBasicAuthenticationWithAuthenticator() throws InterruptedException {

        HttpRequest request =
            HttpRequest
                .newBuilder()
                .timeout(Duration.ofMinutes(2))
                .uri(URI.create("http://localhost:8080/api/users/me"))
                .build();

        HttpClient httpClient = HttpClient
            .newBuilder()
            .authenticator(new Authenticator() {
                public PasswordAuthentication requestPasswordAuthenticationInstance(String host, InetAddress addr, int port, String protocol, String prompt, String scheme, URL url, Authenticator.RequestorType reqType) {
                    String username = "user";
                    String password = "password";
                    return new PasswordAuthentication(username,
                        password.toCharArray());
                }
            }).build();

        httpClient
            .sendAsync(request, HttpResponse.BodyHandlers.ofString())
            .exceptionally(throwable -> {
                throwable.printStackTrace();
                return null;
            })
            .thenApply(resp -> new Object() {
                final int statusCode = resp.statusCode();
                final String body = resp.body();
            })
            .thenAccept(o -> System.out.format("status: %d\tbody: %s\n", o.statusCode, o.body));
        Thread.sleep(20000);
    }

    @Test
    void testFollowingRedirects() throws InterruptedException {
        HttpClient client = HttpClient.newHttpClient();

        String username = "adumbledore";
        String password = "occlumens";

        StringBuilder builder = new StringBuilder();
        builder.append(username);
        builder.append(":");
        builder.append(password);

        Base64.Encoder encoder = Base64.getEncoder();
        HttpRequest request =
            HttpRequest
                .newBuilder()
                .timeout(Duration.ofMinutes(2))
                .uri(URI.create("http://localhost:8080/fruits"))
                .header("Authentication", encoder.encodeToString(builder.toString().getBytes()))
                .build();


        HttpClient.newBuilder()
                  .authenticator(Authenticator.getDefault())
                  .followRedirects(HttpClient.Redirect.ALWAYS);

        Thread.sleep(2000);
    }

    @Test
    void testSSLConnection() throws NoSuchAlgorithmException, IOException,
        InterruptedException {
        SSLContext ssLv3 = SSLContext.getInstance("SSLv3");
        HttpClient httpClient =
            HttpClient.newBuilder()
                      .sslContext(ssLv3)
                      .sslParameters(ssLv3.getDefaultSSLParameters())
                      .build();

        HttpRequest request =
            HttpRequest
                .newBuilder()
                .uri(URI.create("https://localhost:8080/hello"))
                .build();

        HttpResponse<String> response = httpClient.send(request,
            HttpResponse.BodyHandlers.ofString());

        System.out.println(response.body());
    }
}
