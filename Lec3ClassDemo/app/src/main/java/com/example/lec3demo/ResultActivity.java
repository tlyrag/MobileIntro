package com.example.lec3demo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.widget.TextView;

import java.text.DecimalFormat;

public class ResultActivity extends AppCompatActivity {
    final String TAG ="Concert Demo";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        try {
            int numTix = 0;
            Bundle bundle = getIntent().getExtras();
            double costR = bundle.getDouble("COST",0);
            numTix = getIntent().getExtras().getInt("NUMTIX",0);
            String concertType = bundle.getString("TYPE","NOTHING");
            DecimalFormat df = new DecimalFormat("$#.##");
            String outputStr = "Concert Type:" + concertType +"\n"
                    + "Number of Tickets: " + numTix
                    + "Total Cost:" + df.format(costR);

            TextView txtViewResults = findViewById(R.id.textViewResults);
            txtViewResults.setText(outputStr);
            txtViewResults.setGravity(Gravity.CENTER);

        } catch (Exception err) {
            err.printStackTrace();
            Log.d(TAG,"Error in Main Activity"+err.getMessage());

        }
    }
}