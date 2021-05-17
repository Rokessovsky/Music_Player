package test.models;

import model.Playlist;
import model.Song;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PlaylistTest {
    private Playlist pl;
    private Song song1;
    private Song song2;
    private Song song3;

    @BeforeEach
    public void setUp() {
        pl = new Playlist("mine");
        song1 = new Song("c3po", "1");
        song2 = new Song("r2d2","2");
        song3 = new Song("bb8","3");
    }

    @Test
    public void testSettersAndGetters() {
        assertEquals("mine", pl.getName());

        pl.setName("yours");
        assertEquals("yours", pl.getName());

    }

    @Test
    public void testAddSong() {
        assertEquals(0, pl.getSongs().size());
        pl.addSong(song1);
        pl.addSong(song2);
        pl.addSong(song3);
        assertEquals(3,pl.getSongs().size());
    }

    @Test
    public void testRemoveSong() {
        assertEquals(0, pl.getSongs().size());
        pl.addSong(song1);
        pl.addSong(song2);
        pl.addSong(song3);
        assertEquals(3,pl.getSongs().size());
        pl.removeSong(song2);

        assertEquals(2,pl.getSongs().size());
    }
}
