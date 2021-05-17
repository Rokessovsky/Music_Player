package test.persistence;

import model.Playlist;
import model.Song;
import model.User;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import persistence.Reader;
import persistence.Writer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class ReaderTest {
    User user1;
    User user2;
    Playlist pl1;
    Playlist pl2;
    Song song1;
    Song song2;
    Song song3;
    Writer writer;
    Reader reader;
    List<User> users;
    List<Playlist> pls1;
    List<Playlist> pls2;
    String location = "./data/reader_test.json";

    @BeforeEach
    public void setUp() {
        song1 = new Song("space oddity","loc of s1");
        song2 = new Song("gravity","loc of s2");
        song3 = new Song("mona lisa","loc of s3");
        pl1 = new Playlist("80s");
        pl2 = new Playlist("hip pop");
        pl1.addSong(song1);
        pl1.addSong(song2);
        pl2.addSong(song3);
        pls1 = new LinkedList<>();
        pls2 = new LinkedList<>();
        pls1.add(pl1);
        pls2.add(pl1);
        pls2.add(pl2);
        user1 = new User("me","123",pls1);
        user2 = new User("you","abc",pls2);
        users = new LinkedList<>();
    }

    @Test
    public void testReader() {
        try {
            users.add(user1);
            users.add(user2);
            writer = new Writer(location);
            writer.write(users);
            writer.close();
        } catch (IOException e) {
            fail("writer fail to write users");
        }

        try {
            reader = new Reader(location);
            users = reader.read();
            assertEquals(2,users.size());
            assertEquals("me",users.get(0).getName());
            assertEquals("abc",users.get(1).getPassword());
            assertEquals("80s",users.get(0).getPlaylists().get(0).getName());
            assertEquals("mona lisa",users.get(1).getPlaylists().get(1).getSongs().get(0).getName());
        } catch (IOException e) {
            fail("reader IO exception error");
        } catch (ParseException k) {
            fail("reader ParseException error");
        }
    }

    @Test
    public void testIOException() {
        try {
            reader = new Reader("file does not exist");
        } catch (FileNotFoundException e) {
            // expected
        }
    }
}
