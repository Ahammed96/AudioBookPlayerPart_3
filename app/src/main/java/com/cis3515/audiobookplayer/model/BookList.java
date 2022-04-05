package com.cis3515.audiobookplayer.model;

import java.io.Serializable;
import java.util.ArrayList;

public class BookList implements Serializable {
    private ArrayList<Book> books;

    public BookList() {
        books = new ArrayList<>();
    }

    public void add(Book book) {
        books.add(book);
    }

    public void remove(Book book) {
        books.remove(book);
    }

    public Book get(int pos) {
        return books.get(pos);
    }

    public int size() {
        return books.size();
    }
}
