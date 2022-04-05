package com.cis3515.audiobookplayer.model;

import java.io.Serializable;

public class Book implements Serializable {
    private String title;
    private String author;

    public Book(String title, String author){
        this.title = title;
        this.author = author;
    }

    public String getTitle() {
        return this.title;
    }
    public String getAuthor() {
        return this.author;
    }
}
