package com.cis3515.audiobookplayer;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.cis3515.audiobookplayer.model.BookList;

public class Fragment1 extends Fragment {
    private BookList bookList;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            bookList = (BookList) getArguments().getSerializable("bookList");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return setupRecyclerView(inflater.inflate(R.layout.fragment1, container, false));
    }

    private View setupRecyclerView(View view) {
        RecyclerView rv = view.findViewById(R.id.recyclerView);
        rv.setHasFixedSize(true);
        rv.setLayoutManager(new LinearLayoutManager(view.getContext()));
        rv.setAdapter(new BookListAdapter(bookList, getActivity()));
        return view;
    }

    public static Fragment1 newInstance(BookList bookList) {
        Fragment1 fragment = new Fragment1();
        Bundle args = new Bundle();
        args.putSerializable("bookList", bookList);
        fragment.setArguments(args);
        return fragment;
    }
}