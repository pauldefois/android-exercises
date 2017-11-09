package fr.android.androidexercises;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

public class BookAdapter extends RecyclerView.Adapter<BookAdapter.BookViewHolder> {
    private final List<Book> books;
    private LayoutInflater inflater;

    public BookAdapter(LayoutInflater inflater, List<Book> books) {
        this.books = books;
        this.inflater = inflater;
    }

    @Override
    public BookAdapter.BookViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new BookViewHolder(inflater.inflate(R.layout.custom_view_item_book, parent, false));
    }

    @Override
    public void onBindViewHolder(BookAdapter.BookViewHolder holder, int position) {
        ((BookItemView) holder.itemView).bindView(books.get(position));
    }

    @Override
    public int getItemCount() {
        return books.size();
    }

    class BookViewHolder extends RecyclerView.ViewHolder{
        public BookViewHolder(View itemView) {
            super(itemView);
        }
    }
}
