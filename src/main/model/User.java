package model;


import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class User {

    private String name;
    private String password;
    private List<Playlist> playlists;


    //constructor
    public User(String name, String password) {
        this.name = name;
        this.password = password;
        playlists = new ArrayList<>();
    }

    public User(String name, String password, List<Playlist> playlists) {
        this.name = name;
        this.password = password;
        this.playlists = playlists;
    }

    //MODIFIES: json object.
    //EFFECTS: return a json object with all user details
    public JSONObject userDetails() {
        JSONObject user = new JSONObject();
        user.put("user name",name);
        user.put("password",password);
        user.put("user playlists",plToJSon());
        return user;
    }

    private JSONArray plToJSon() {
        JSONArray pls = new JSONArray();

        for (Playlist pl : playlists) {
            pls.put(pl.playlistDetails());
        }
        return pls;
    }

    //MODIFIES: this
    //EFFECTS: add playlist
    public void addPlaylist(Playlist pl) {
        if (!playlists.contains(pl)) {
            playlists.add(pl);
        }
    }

    //MODIFIES: this
    //EFFECTS: remove a playlist
    public void removePlaylist(Playlist pl) {
        playlists.remove(pl);
    }

    //getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Playlist> getPlaylists() {
        return playlists;
    }

    public void setPlaylists(ArrayList<Playlist> playlists) {
        this.playlists = playlists;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return Objects.equals(name, user.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
