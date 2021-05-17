package model;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Objects;

public class Playlist {
    private String name;
    private ArrayList<Song> songs;

    //constructor
    public Playlist(String name) {
        this.name = name;
        songs = new ArrayList<Song>();
    }

    public JSONObject playlistDetails() {
        JSONObject pl = new JSONObject();
        pl.put("playlist name", name);
        pl.put("songs",sonsToJson());
        return pl;
    }

    private JSONArray sonsToJson() {
        JSONArray jsonArray = new JSONArray();

        for (Song song : songs) {
            jsonArray.put(song.songDetails());
        }

        return jsonArray;
    }

    //getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Song> getSongs() {
        return songs;
    }

    public void setSongs(ArrayList<Song> songs) {
        this.songs = songs;
    }

    //MODIFIES: this
    //EFFECT: add song
    public void addSong(Song song) {
        songs.add(song);
    }

    //EFFECT: find the source of the song given the name of the song
    public boolean removeSong(Song song) {
        return songs.remove(song);
    }





    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Playlist playlist = (Playlist) o;
        return Objects.equals(name, playlist.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }




}
