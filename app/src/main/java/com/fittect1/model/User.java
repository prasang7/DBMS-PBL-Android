package com.fittect1.model;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by prasang7 on 5/11/16.
 */
public class User extends RealmObject {

    @PrimaryKey
    private String email;

    private String name, password;

    public User() { }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}