package com.evolutionnext.records;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RecordsTest {
    @Test
    void testCreationOfAlbumAndShowToString() {
        var album = new Album("Purple Rain",
            new Genre("Rock"), new Artist("Prince", "Rogers", "Nelson"));
        String s = album.toString();
        assertThat(s).isEqualTo("{}ASD");
    }
}
