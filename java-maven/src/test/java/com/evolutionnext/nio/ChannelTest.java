package com.evolutionnext.nio;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.IntBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.Pipe;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static java.nio.file.StandardOpenOption.*;
import static org.assertj.core.api.Assertions.assertThat;

public class ChannelTest {

        String userDirectory = System.getProperty("user.dir");


    @Test
    void testTransferFromOneFileToAnother() throws IOException {

        System.out.println(userDirectory);
        FileChannel inChannel = FileChannel.open(Path.of(userDirectory, "src" +
            "/main/resources", "sample.txt"), READ);
        FileChannel outChannel = FileChannel.open(Path.of(userDirectory, "src" +
            "/main/resources", "out.txt"), CREATE, WRITE);

        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(1024);
        byteBuffer.clear();

        while ((inChannel.read(byteBuffer)) != -1) {
            byteBuffer.flip();
            outChannel.write(byteBuffer);
            byteBuffer.clear();
        }

        inChannel.close();
        outChannel.close();
    }

    @Test
    void testWritingBufferWithPut() {
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        byteBuffer.putInt(10);

        try (FileChannel fileChannel = FileChannel.open(Path.of(userDirectory
            , "src/main/resources", "ints.bin"), CREATE, WRITE)) {
            fileChannel.write(byteBuffer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    void testBufferWithPutAndGet() {
        IntBuffer intBuffer = IntBuffer.allocate(32 * 1000);
        intBuffer.put(30);
        intBuffer.put(40);
        intBuffer.flip(); //set to the beginning
        assertThat(intBuffer.get()).isEqualTo(30);
        assertThat(intBuffer.get()).isEqualTo(40);
    }


    /**
     * Compact takes all unread data and moves it to the beginning of the
     * buffer.
     */
    @Test
    void testBufferUsingCompact() {
        IntBuffer intBuffer = IntBuffer.allocate(32 * 1000);
        intBuffer.put(30);
        debugBuffer(intBuffer);
        intBuffer.put(40);
        debugBuffer(intBuffer);
        intBuffer.put(50);
        debugBuffer(intBuffer);
        intBuffer.put(60);
        debugBuffer(intBuffer);
        intBuffer.flip(); //set to the beginning
        debugBuffer(intBuffer);
        assertThat(intBuffer.get()).isEqualTo(30);
        assertThat(intBuffer.get()).isEqualTo(40);
        intBuffer.compact();
        debugBuffer(intBuffer);
    }

    public void debugBuffer(Buffer buffer) {
        System.out.printf("limit: %d, position: %d, capacity: %d\n",
            buffer.limit(), buffer.position(), buffer.capacity());
    }

    @Test
    void testResettingToMark() {
        IntBuffer intBuffer = IntBuffer.allocate(32 * 1000);
        intBuffer.put(30);
        debugBuffer(intBuffer);
        intBuffer.put(40);
        debugBuffer(intBuffer);
        intBuffer.put(50);
        debugBuffer(intBuffer);
        intBuffer.put(60);
        debugBuffer(intBuffer);
        intBuffer.flip(); //set to the beginning
        debugBuffer(intBuffer);
        intBuffer.mark(); //set the mark
        assertThat(intBuffer.get()).isEqualTo(30);
        assertThat(intBuffer.get()).isEqualTo(40);
        intBuffer.reset(); //reset here
        assertThat(intBuffer.get()).isEqualTo(30);
        assertThat(intBuffer.get()).isEqualTo(40);
        debugBuffer(intBuffer);
    }

    @Test
    void testFanOutReads() {
        try (FileChannel inChannel = FileChannel.open(Path.of(userDirectory,
            "src" +
                "/main/resources", "sample.txt"), READ)) {
            ByteBuffer byteBuffer = ByteBuffer.allocate(16 * 3);
            ByteBuffer byteBuffer2 = ByteBuffer.allocate(1024);

            byteBuffer.clear();
            byteBuffer2.clear();

            inChannel.read(new ByteBuffer[]{byteBuffer, byteBuffer2});

            byteBuffer.flip();
            byteBuffer2.flip();

            CharBuffer charBuffer = StandardCharsets.UTF_8.decode(byteBuffer);
            while (charBuffer.hasRemaining()) {
                System.out.println("From Buffer 1:" + charBuffer.get());
            }

            CharBuffer charBuffer2 = StandardCharsets.UTF_8.decode(byteBuffer2);
            while (charBuffer2.hasRemaining()) {
                System.out.println("From Buffer 2:" + charBuffer2.get());
            }

            debugBuffer(charBuffer2);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    void testFanInWrites() {
        try (FileChannel outChannel = FileChannel.open(Path.of(userDirectory,
            "src/main/resources", "fanin.txt"), CREATE, WRITE)) {

            CharBuffer charBuffer1 =
                CharBuffer.wrap("This is the header".toCharArray());

            CharBuffer charBuffer2 =
                CharBuffer.wrap("This is the footer".toCharArray());

            ByteBuffer byteBuffer1 =
                StandardCharsets.UTF_8.encode(charBuffer1);
            ByteBuffer byteBuffer2 =
                StandardCharsets.UTF_8.encode(charBuffer2);

            outChannel.write(new ByteBuffer[]{byteBuffer1, byteBuffer2});
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * The transferTo() method transfer from a FileChannel into some
     * other channel. The parameters position and count, tell where in the
     * destination file to start writing (position), and how many bytes
     * to transfer maximally (count). If the source channel
     * has fewer than count bytes, less is transfered.
     */
    @Test
    void testTransferTo() {
        try (FileChannel inChannel = FileChannel.open(Path.of(userDirectory,
            "src/main/resources", "sample.txt"), READ);
             FileChannel outChannel = FileChannel.open(Path.of(userDirectory,
                 "src/main/resources", "out.txt"), CREATE, WRITE);
        ) {
            inChannel.transferTo(0, 1024, outChannel);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * The transferFrom() method transfers data from a source channel
     * into the FileChannel
     */
    @Test
    void testTransferFrom() {
        try (FileChannel inChannel = FileChannel.open(Path.of(userDirectory,
            "src/main/resources", "sample.txt"), READ);
             FileChannel outChannel = FileChannel.open(Path.of(userDirectory,
                 "src/main/resources", "out.txt"), CREATE, WRITE);
        ) {
            outChannel.transferFrom(inChannel, 0, 1024);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Java NIO Pipe is a one-way data connection between two threads.
     * A Pipe has a source channel and a sink channel. You write data
     * to the sink channel. This data can then be read from the source channel.
     */
    @Test
    void testUsingPipe() throws IOException {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        Pipe pipe = Pipe.open();
        executorService.submit(() -> {
            try {
                Pipe.SinkChannel sinkChannel = pipe.sink();
                ByteBuffer byteBuffer = StandardCharsets.UTF_8.encode("This " +
                    "should be" +
                    " received on another Thread");
                sinkChannel.write(byteBuffer);
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
        });

        executorService.submit(() -> {
            Pipe.SourceChannel sourceChannel = pipe.source();
            ByteBuffer byteBuffer = ByteBuffer.allocateDirect(1024);
            try {
                sourceChannel.read(byteBuffer);
                byteBuffer.flip();
                CharBuffer decode =
                    StandardCharsets.UTF_8.decode(byteBuffer);
                System.out.println(new String(decode.array()));
                decode.clear();
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
        });
    }
}
