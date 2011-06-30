package com.foa.domain;

import javax.persistence.*;

/**
 * Created by IntelliJ IDEA.
 * User: yerinle
 * Date: 05/06/2011
 * Time: 12:53
 * To change this template use File | Settings | File Templates.
 */

@Entity
@Table(name = "members")
public class Member {

    private String firstName;
    private String lastName;
    private Long id;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Member() {
    }

    public Member(String firstName, String lastName) {
        this.firstName = firstName;

        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String toString() {
        return firstName + " " + lastName;
    }
}
