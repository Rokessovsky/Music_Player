package persistence;

import model.Playlist;
import model.Song;
import model.User;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

// Represents a class that reads data from a JSON file
public class Reader {
    protected FileReader source;
    protected User user;

    //EFFECTS: construct reader to read file from source file
    public Reader(String source) throws FileNotFoundException {
        this.source = new FileReader(source);
    }

//    // EFFECTS: reads source file as string and returns it
//    protected String readFile(String source) throws IOException {
//        StringBuilder contentBuilder = new StringBuilder();
//
//        try (Stream<String> stream = Files.lines(Paths.get(source), StandardCharsets.UTF_8)) {
//            stream.forEach(contentBuilder::append);
//        }
//
//        return contentBuilder.toString();
//    }

    //EFFECTS: read user from file and return it;
    // throw IOException if an error occurs reading data from file
    public List<User> read() throws IOException, ParseException {
        List<User> users = new LinkedList<>();

        JSONParser jsonParser = new JSONParser();
        JSONObject data = (JSONObject) jsonParser.parse(source);

        HashMap<String, JSONObject> tempMap = new HashMap(data);
        
        for (String str: tempMap.keySet()) {
            user = parseUser(tempMap.get(str));
            users.add(user);
        }
        
        return users;

    }

    private User parseUser(JSONObject data) {
        String name = (String) data.get("user name");
        String password = (String) data.get("password");
        JSONArray pls = (JSONArray) data.get("user playlists");
        user = new User(name,password);
        for (Object k: pls) {
            parsePlaylist((JSONObject) k);
        }
        return user;
    }

    private void parsePlaylist(JSONObject data) {
        String plName = (String) data.get("playlist name");
        JSONArray songs = (JSONArray) data.get("songs");
        Playlist pl = new Playlist(plName);
        user.addPlaylist(pl);
        for (Object k: songs) {
            parseSong((JSONObject) k, pl);
        }
    }

    private void parseSong(JSONObject song, Playlist pl) {
        String name = (String) song.get("song name");
        String source = (String) song.get("song source");
        Song s = new Song(name,source);
        pl.addSong(s);
    }


}
