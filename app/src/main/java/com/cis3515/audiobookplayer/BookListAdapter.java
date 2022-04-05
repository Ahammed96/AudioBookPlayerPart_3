package com.cis3515.audiobookplayer;

import android.app.Activity;
import android.content.res.Configuration;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import com.cis3515.audiobookplayer.model.BookList;

public class BookListAdapter extends RecyclerView.Adapter<BookListAdapter.ViewHolder> {
    private BookList books;
    private FragmentActivity activity;
    private BooksViewModel activityData;

    BookListAdapter(BookList books, FragmentActivity activity) {
        this.books = books;
        this.activity = activity;
        this.activityData = new ViewModelProvider(activity).get(BooksViewModel.class);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(
                LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.rv_item, parent, false)
        );
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.titleView.setText(books.get(position).getTitle());
        holder.authorView.setText(books.get(position).getAuthor());
    }

    @Override
    public int getItemCount() {
        return books.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView titleView;
        TextView authorView;
        View view;

        ViewHolder(View itemView) {
            super(itemView);
            view = itemView;
            titleView = itemView.findViewById(R.id.title);
            authorView = itemView.findViewById(R.id.author);
            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            activityData.selectBook(books.get(getAbsoluteAdapterPosition()));
            int orientation = activity.getResources().getConfiguration().orientation;
            FragmentManager fragmentManager = activity.getSupportFragmentManager();
            if(orientation == Configuration.ORIENTATION_LANDSCAPE) {
                ((Fragment2)fragmentManager.findFragmentById(R.id.fragment2)).displayBook(activityData.getSelectedBook());
            } else {
                fragmentManager.beginTransaction()
                        .replace(R.id.fragment1, Fragment2.newInstance(activityData.getSelectedBook()))
                        .addToBackStack(null)
                        .commit();
            }
        }
    }
}