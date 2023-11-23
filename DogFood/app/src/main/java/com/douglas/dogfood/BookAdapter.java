package com.douglas.dogfood;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;


public class BookAdapter extends BaseAdapter {
    public final String TAG = "BookStore APP";
    public ArrayList<Book> bookList;
    TextView textViewCartTitle;
    TextView textViewCartPrice;

    public void setBookList(ArrayList<Book> bookList) {
        this.bookList = bookList;
        notifyDataSetChanged();
    }

    public BookAdapter(ArrayList<Book> bookList) {
        this.bookList = bookList;
    }

    @Override
    public int getCount() {
        return bookList.size();
    }

    @Override
    public Object getItem(int i) {
        return bookList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if(view==null) {

            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_cart_view,viewGroup,false);
            getItensInCartView(view);
            setItensInCartView(view,i);

        }
        return view;
    }

    /**
     *
     * Methods used in getView
     *
     * */
    public void getItensInCartView(View view) {
        try {
            textViewCartPrice = view.findViewById(R.id.textViewCartBookPrice);
            textViewCartTitle = view.findViewById(R.id.textViewCartBookTitle);
        } catch (Exception err) {
            Log.d(TAG, "getItensInCartView: " + err.getMessage());
        }
    }

    public void setItensInCartView (View view, int i) {
        try{
            textViewCartPrice.setText(bookList.get(i).getPrice().toString());
            textViewCartTitle.setText(bookList.get(i).getTitle());

        } catch (Exception err) {
            Log.d(TAG, "setItensInCartView: " + err.getMessage());
        }
    }
}
