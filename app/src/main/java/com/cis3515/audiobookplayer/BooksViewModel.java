package com.cis3515.audiobookplayer;

import androidx.lifecycle.ViewModel;

import com.cis3515.audiobookplayer.model.Book;

public class BooksViewModel extends ViewModel {
    private Book selectedBook = null;

    public void selectBook(Book book) {
        selectedBook = book;
    }

    public Book getSelectedBook() {
        return selectedBook;
    }
}
