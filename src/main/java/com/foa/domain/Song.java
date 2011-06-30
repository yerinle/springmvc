package com.foa.domain;

import javax.persistence.*;

/**
 * Created by IntelliJ IDEA.
 * Date: 29/06/2011
 * Time: 19:13
 * To change this template use File | Settings | File Templates.
 */

@Entity
@Table(name = "songs")
public class Song {
    private SongPK id;
    private String title;
    private Album album;

    public Song() {
    }

    @Id
    public SongPK getId() {
        return id;
    }

    public void setId(SongPK id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @ManyToOne
    @JoinColumn(name = "albumId", insertable = false, updatable = false)
    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Song song = (Song) o;

        if (id != null ? !id.equals(song.getId()) : song.getId() != null) return false;
        if (title != null ? !title.equals(song.getTitle()) : song.getTitle() != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        return result;
    }

}
