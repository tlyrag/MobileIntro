package com.douglas.dogfood;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.io.Serializable;

public class Checkout extends AppCompatActivity {
    Serializable cartBookList;
    public final String TAG ="Book APP";
    double finalPrice;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);

        try {
            Bundle bundle = getIntent().getExtras();
            cartBookList = bundle.getString("Books","None");
            finalPrice = bundle.getDouble("FinalPrice");
            TextView txtBooks = findViewById(R.id.textViewBookCarts);
            TextView txtPrice = findViewById(R.id.textViewCartPrice);

            txtPrice.setText(Double.toString(finalPrice));
            txtBooks.setText(cartBookList + "");
            //txtBooks.setText("TEstannddooo");

        } catch (Exception err) {
            Log.d(TAG, "onCreate: Failed to get Bundle: "+ err.getMessage() );
        }



    }
}
