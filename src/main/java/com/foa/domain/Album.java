package com.foa.domain;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by IntelliJ IDEA.
 * Date: 29/06/2011
 * Time: 19:12
 * To change this template use File | Settings | File Templates.
 */

@Entity
@Table(name = "albums")
public class Album {
    private Long id;
    private String title;
    private Date releaseDate;

//    @OneToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE },
//    mappedBy = "albums")

    private Set<Song> songs = new HashSet<Song>();

    public Album() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Column
    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    @OneToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE }, mappedBy = "album")
    public Set<Song> getSongs() {
        return songs;
    }

    public void setSongs(Set<Song> songs) {
        this.songs = songs;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Album album = (Album) o;

        if (id != null ? !id.equals(album.getId()) : album.getId() != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
