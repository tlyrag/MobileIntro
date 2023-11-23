package com.douglas.dogfood;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.Struct;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    public final String TAG = "App BookStore";


    /// Views In Layout
    TextView txtBookTitle;
    TextView txtBookAuthor;
    TextView txtBookGenre;
    TextView txtBookPrice;
    TextView txtBookStock;
    TextView txtFinalPrice;
    Spinner bookSpinner;
    Button btnAddToCart;
    Button btnClearCart;
    Button btnPurchase;
    RadioButton radioBtnNormalDelivery;
    RadioButton radioButtonFastDelivery;
    RadioGroup radioGroupDeliveryMethod;
    ListView cartView;
    Book currBook;

    //// Data in the Layout
    ArrayList<Book> bookList = new ArrayList<>();
    ArrayList<Book> cartBookList = new ArrayList<>();
    double FinalPrice = 0;

    /// Adapter Objects
    BookAdapter bookAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "Working");
        loadData();
        getViewItems();

        bookSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                setViewItems(i);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        btnAddToCart.setOnClickListener(view -> {
            cartBookList.add(currBook);
            bookAdapter = new BookAdapter(cartBookList);
            cartView.setAdapter(bookAdapter);
            FinalPrice = getFinalPrice(cartBookList,0,cartBookList.size()-1);
            txtFinalPrice.setText("Final Price: "+FinalPrice);

        });

        btnClearCart.setOnClickListener(view -> {
            cartBookList.clear();
            bookAdapter = new BookAdapter(cartBookList);
            cartView.setAdapter(bookAdapter);
        });

        btnPurchase.setOnClickListener(view -> {

            addDeliveryFee();
            txtFinalPrice.setText("Final Price: "+FinalPrice);
            goToCartActivity();
        });





    }

    public void getViewItems() {
        try {
            // Text Views
            txtBookTitle = findViewById(R.id.textViewBookTitle);
            txtBookAuthor = findViewById(R.id.textViewBookAuthor);
            txtBookGenre = findViewById(R.id.textViewBookGenre);
            txtBookPrice = findViewById(R.id.textViewBookPrice);
            txtBookStock = findViewById(R.id.textViewBookStock);

            // Buttons
            btnPurchase = findViewById(R.id.btnViewPurchase);
            btnClearCart = findViewById(R.id.btnViewClearCart);
            btnAddToCart = findViewById(R.id.btnViewAddToCart);
            // Spinner
            bookSpinner = findViewById(R.id.spinnerBookSelector);

            //Radio Buttons and Group
            radioGroupDeliveryMethod = findViewById(R.id.rdGroupDelivery);
            radioBtnNormalDelivery= findViewById(R.id.radioBtnViewNormalDelivery);
            radioButtonFastDelivery = findViewById(R.id.radioBtnViewFastDelivery);

            cartView = findViewById(R.id.listView);
            txtFinalPrice= findViewById(R.id.textViewFinalPrice);
        } catch (Exception err) {
            Log.d(TAG, "Error getting View Items" + err.getMessage());
        }
    }

    public void loadData() {
        try {
            Book book1 = new Book(1, "Great Gatsby", "Uknown", "Fiction", 15.5, 8);
            Book book2 = new Book(1, "Lord of the Rings", "Tolkien", "Fiction", 20.5, 8);
            Book book3 = new Book(1, "Harry Potter", "JK Rolling", "Fiction", 17.5, 8);
            Book book4 = new Book(1, "Wheel of Time", "Prime Video", "Fiction", 19.5, 8);
            Book book5 = new Book(1, "Game of Thrones", "RR Martin", "Fiction", 35.5, 8);

            bookList.add(book1);
            bookList.add(book2);
            bookList.add(book3);
            bookList.add(book4);
            bookList.add(book5);
        } catch (Exception err) {
            Log.d(TAG, "Error Loading Data" + err.getMessage());
        }

    }

    public void setViewItems(int i) {
        try {

            currBook = bookList.get(i);
            Log.d(TAG, "setViewItems: CurrentBook is:" + currBook);
            txtBookTitle.setText(currBook.getTitle());
            txtBookAuthor.setText(currBook.getAuthor());
            txtBookGenre.setText(currBook.getGenre());
            txtBookPrice.setText(currBook.getPrice().toString());
            txtBookStock.setText(currBook.getStock());
        } catch (Exception err) {
            Log.d(TAG, "setViewItems: ");
        }


    }

    public double getFinalPrice(ArrayList<Book> books, int first, int last) {
        double finalPrice =0;

        finalPrice += books.get(first).Price;

        if(first<last) {
          finalPrice+=  getFinalPrice(books, first + 1, last);
        }
        return finalPrice;
    }

    public void addDeliveryFee() {
        if (radioGroupDeliveryMethod.getCheckedRadioButtonId()==radioButtonFastDelivery.getId()) {
            FinalPrice+=10.00;
        }
    }

    public void goToCartActivity() {

        if(radioGroupDeliveryMethod.getCheckedRadioButtonId()==-1) {
            Toast.makeText(this, "Please Select Delivery Method", Toast.LENGTH_SHORT).show();
        } else {
            Intent checkoutIntent = new Intent(MainActivity.this,Checkout.class);
            Bundle bundle = new Bundle();

            //bundle.putSerializable("cartBookList",cartBookList);
            StringBuilder str = new StringBuilder();

            for(int i =0;i<cartBookList.size();i++) {
                if(i!=cartBookList.size()-1) {
                    str.append(cartBookList.get(i).getTitle());
                } else {
                    str.append(cartBookList.get(i).getTitle() + "\n");
                }

            }
            String books = str.toString();
            bundle.putString("Books",books);
            bundle.putDouble("FinalPrice",FinalPrice);
            checkoutIntent.putExtras(bundle);

            startActivity(checkoutIntent);
        }
    }
}