package com.evolutionnext.nio;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.Arrays;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class PathsFilesTest {

    /**
     * Path represent the path on the system
     * File represent the file
     * Paths is the static utility class for paths
     * Files is the static utility class for files
     */
    @Test
    void testFileExist() {
        String p = System.getProperties().getProperty("java.home");
        Path path = Paths.get(p, "bin", "java");
        assertThat(Files.exists(path, LinkOption.NOFOLLOW_LINKS)).isTrue();
    }

    @Test
    void testCreateDirectory() throws IOException {
        String p = System.getProperties().getProperty("user.home");
        Path newDirectory = Paths.get(p, "test_dir");
        Files.createDirectory(newDirectory);
    }

    @Test
    void testCopyingFiles() throws IOException {
        //Path.of is another way to get a path.
        String userDirectory = System.getProperty("user.dir");
        Path source = Path.of(userDirectory, "src/main/resources", "sample" +
            ".txt");
        Path destination = Path.of(userDirectory, "src/main/resources",
            "sample-copy.txt");
        Files.copy(source, destination, StandardCopyOption.COPY_ATTRIBUTES,
            StandardCopyOption.REPLACE_EXISTING);
    }

    @Test
    void testStreaming() throws IOException {
        String userDirectory = System.getProperty("user.dir");
        Path source = Path.of(userDirectory, "src/main/resources", "sample" +
            ".txt");
        long wordsWithOvCount =
            Files.lines(source, StandardCharsets.UTF_8)
                 .flatMap(s -> Arrays.stream(s.split("\\W+")))
                 .map(String::toLowerCase)
                 .filter(w -> w.contains("ov"))
                 .count();

        assertThat(wordsWithOvCount).isEqualTo(3);
    }

    /**
     * Walking will walk the path of the directory
     * and return a stream of the directories. PathMatchers
     * can allows us to dig even further into the directory.
     */
    @Test
    void testWalking() throws IOException, InterruptedException {
        String userDirectory = System.getProperty("user.dir");
        Stream<Path> pathStream = Files.walk(Path.of(userDirectory));
        PathMatcher pathMatcher = FileSystems.getDefault().getPathMatcher(
            "glob:**.java");
        pathStream
            .filter(pathMatcher::matches)
            .forEach(p -> System.out.println(p.toString()));
        Thread.sleep(3000);
    }
}
