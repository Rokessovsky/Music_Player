package test.models;

import model.Playlist;
import model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserTest {
    private User user;
    private Playlist pl1;
    private Playlist pl2;
    private Playlist pl3;

    @BeforeEach
    public void setUp() {
        user = new User("mine","123");
        pl1 = new Playlist("c3po");
        pl2 = new Playlist("r2d2");
        pl3 = new Playlist("bb8");
    }

    @Test
    public void testGettersAndSetters() {
        assertEquals("mine", user.getName());
        assertEquals("123", user.getPassword());

        user.setName("Luke");
        user.setPassword("SkyWalker");

        assertEquals("Luke",user.getName());
        assertEquals("SkyWalker", user.getPassword());
    }

    @Test
    public void testAddPlaylist() {
        assertEquals(0,user.getPlaylists().size());

        user.addPlaylist(pl1);
        user.addPlaylist(pl2);
        user.addPlaylist(pl3);
        user.addPlaylist(pl1);

        assertEquals(3, user.getPlaylists().size());

    }
}
