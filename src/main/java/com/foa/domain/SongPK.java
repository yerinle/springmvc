package com.foa.domain;

import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Created by IntelliJ IDEA.
 * Date: 29/06/2011
 * Time: 19:15
 * To change this template use File | Settings | File Templates.
 */

@Embeddable
public class SongPK implements Serializable {
    private Long songId;
    private Long albumId;

    public SongPK() {
    }

    public Long getSongId() {
        return songId;
    }

    public void setSongId(Long songId) {
        this.songId = songId;
    }

    public Long getAlbumId() {
        return albumId;
    }

    public void setAlbumId(Long albumId) {
        this.albumId = albumId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SongPK songPK = (SongPK) o;

        if (albumId != null ? !albumId.equals(songPK.getAlbumId()) : songPK.getAlbumId() != null) return false;
        if (songId != null ? !songId.equals(songPK.getSongId()) : songPK.getSongId() != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = songId != null ? songId.hashCode() : 0;
        result = 31 * result + (albumId != null ? albumId.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "SongPK{" +
                "songId=" + songId +
                ", albumId=" + albumId +
                '}';
    }
}
