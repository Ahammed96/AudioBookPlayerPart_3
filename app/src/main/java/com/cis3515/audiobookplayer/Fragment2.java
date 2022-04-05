package com.cis3515.audiobookplayer;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.cis3515.audiobookplayer.model.Book;

public class Fragment2 extends Fragment {
    private Book book;
    private View view;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            book = (Book) getArguments().getSerializable("book");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment2, container, false);
        displayBook(this.book);
        return view;
    }

    public void displayBook(Book b) {
        if(b != null) {
            this.book = b;
            TextView authorView = view.findViewById(R.id.author);
            TextView titleView = view.findViewById(R.id.title);
            titleView.setText(book.getTitle());
            authorView.setText(book.getAuthor());
        }
    }

    public static Fragment newInstance(Book book) {
        Fragment2 fragment = new Fragment2();
        Bundle args = new Bundle();
        args.putSerializable("book", book);
        fragment.setArguments(args);
        return fragment;
    }
}