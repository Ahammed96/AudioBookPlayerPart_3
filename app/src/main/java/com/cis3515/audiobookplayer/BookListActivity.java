package com.cis3515.audiobookplayer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelProvider;

import android.content.res.Configuration;
import android.os.Bundle;

import com.cis3515.audiobookplayer.model.Book;
import com.cis3515.audiobookplayer.model.BookList;

public class BookListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        removeAllFragments();
        showFragmentsBasedOnOrientation(new ViewModelProvider(this).get(BooksViewModel.class));
    }

    private void removeAllFragments() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        for (Fragment fragment : fragmentManager.getFragments()) {
            fragmentManager.beginTransaction().remove(fragment).commit();
        }
    }

    private void showFragmentsBasedOnOrientation(BooksViewModel viewModel) {
        int orientation = getResources().getConfiguration().orientation;
        FragmentManager fragmentManager = getSupportFragmentManager();

        if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
            fragmentManager.beginTransaction()
                .add(R.id.fragment1, Fragment1.newInstance(getBooks()), "booklist")
                .add(R.id.fragment2, Fragment2.newInstance(viewModel.getSelectedBook()), "bookdetail")
                .commit();
        } else {
            fragmentManager.beginTransaction()
                .add(R.id.fragment1, Fragment1.newInstance(getBooks()), "booklist")
                .commit();
        }
    }

    private BookList getBooks() {
        BookList books = new BookList();
        for(int i=1; i<=20; i++) {
            books.add(new Book("Book " + i, "Author " + i));
        }
        return books;
    }
}