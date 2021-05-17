package model;

import org.json.JSONObject;

import java.util.Objects;

public class Song {
    private String name;
    private String source;

    //constructor
    //construct a song
    public Song(String name, String source) {
        this.name = name;
        this.source = source;
    }

    //MODIFIES: JSON object
    //EFFECTS: return a JSON object representing song with corresponding details
    public JSONObject songDetails() {
        JSONObject song = new JSONObject();

        song.put("song name",name);
        song.put("song source",source);

        return song;
    }

    /////////////////////////
    //getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }
    /////////////////////////


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Song song = (Song) o;
        return Objects.equals(name, song.name) &&
                Objects.equals(source, song.source);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, source);
    }


}
