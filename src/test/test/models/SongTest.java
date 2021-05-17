package test.models;

import model.Song;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SongTest {
    private Song testSong;

    @BeforeEach
    public void setUp() {
        testSong = new Song("testSong","fakeSource");
    }

    @Test
    public void testSettersAndGetters() {
        assertEquals("testSong",testSong.getName());
        assertEquals("fakeSource",testSong.getSource());

        testSong.setName("changed name");
        assertEquals("changed name", testSong.getName());

        testSong.setSource("c3po");
        assertEquals("c3po",testSong.getSource());

    }


}
