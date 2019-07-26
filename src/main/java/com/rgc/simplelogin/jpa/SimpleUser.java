/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rgc.simplelogin.jpa;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Rodrigo Garcia
 * Era User, pero choca con la normal SQL.
 */
@Entity
@Table(name = "simple_user")
public class SimpleUser implements Serializable {

    public final static long serialVersionUID = 7312614182716967151L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Column(name = "nickname", nullable = false, unique = true, length = 50)
    private String nickname;
    @Column(name = "password", nullable = false, length = 50)
    private String password;

    public SimpleUser() {
    }

    public SimpleUser(String nickname, String password) {
        this.id = null;
        this.nickname = nickname;
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
