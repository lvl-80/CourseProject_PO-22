package com.lvl80.lingua.Types;

import java.io.Serializable;

public class User implements Serializable {
    private String login;
    private String mail;
    private String password;
    private int level;
    private int mistakes;
    private float mark;

    public User() {
    }

    public User(String login, String mail, String password, int level, int mistakes, float mark) {
        this.login = login;
        this.password = password;
        this.level = level;
        this.mail = mail;
        this.mistakes = mistakes;
        this.mark = mark;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public int getMistakes() {
        return mistakes;
    }

    public void setMistakes(int mistakes) {
        this.mistakes = mistakes;
    }

    public float getMark() {
        return mark;
    }

    public void setMark(float mark) {
        this.mark = mark;
    }
}
