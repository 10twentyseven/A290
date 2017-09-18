package com.a290.kevin.assignment3music;

/**
 * Created by Kevin on 9/13/2017.
 */

public class Artist {
    private String name;
    private String description;
    private String genre;
    private int artistId;

    public Artist(String name, String description, String genre, int artistId) {
            this.name = name;
            this.description = description;
            this.genre = genre;
            this.artistId = artistId;
        }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getGenre() {
        return genre;
    }

    public int getArtistId() {
        return artistId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setArtistId(int iconId) {
        this.artistId = iconId;
    }
}
