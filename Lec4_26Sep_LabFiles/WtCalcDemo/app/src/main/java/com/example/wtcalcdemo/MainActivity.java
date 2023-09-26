package com.example.wtcalcdemo;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
     final String Tag = "WT Demo";
     TextView txtViewResults;
     EditText editTextInputWp;
     Button btnConvertWt;
     RadioGroup radGroupConv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        try {
            ActionBar actionBar = getSupportActionBar();
            actionBar.setDisplayShowHomeEnabled(true);
            actionBar.setDisplayUseLogoEnabled(true);
            actionBar.setLogo(R.mipmap.ic_launcher_wt);
            actionBar.setTitle(R.string.txtTitle);

            txtViewResults= findViewById(R.id.txtViewResults);
            editTextInputWp= findViewById(R.id.editTextInputWt);
            btnConvertWt = findViewById(R.id.btnConvertWt);
            radGroupConv = findViewById(R.id.radGroupConv);

            btnConvertWt.setOnClickListener(view -> {

                if(radGroupConv.getCheckedRadioButtonId() == -1) {
                    Toast.makeText(this, "Please check Conversion Type", Toast.LENGTH_SHORT).show();
                } else {
                    double inputWt = 0, outputWt = 0;
                    try {
                        Log.d(Tag,"Get Here:");
                        inputWt = Double.parseDouble(editTextInputWp.getText().toString());
                        Log.d(Tag,"Get Here 1: "+ inputWt);
                        if(inputWt<0) {
                            Toast.makeText(this, "Input Weight must be > 0", Toast.LENGTH_SHORT).show();
                        } else if (radGroupConv.getCheckedRadioButtonId() ==R.id.radBtnKgToLbs) {
                            if(inputWt>500) {
                                Toast.makeText(this, "Baggage Limit Exceded", Toast.LENGTH_SHORT).show();
                            } else {
                                Log.d(Tag,"Get Here 3: "+ inputWt);
                                outputWt = inputWt*2.2;
                                Log.d(Tag,"Get Here 4: "+ outputWt);
                                txtViewResults.setText(Double.toString(outputWt));
                            }
                        } else if(radGroupConv.getCheckedRadioButtonId() == R.id.radBtnLbsToKg) {
                            if(inputWt>1000) {
                                Toast.makeText(this, "Baggage Limit Exceded", Toast.LENGTH_SHORT).show();
                            } else {
                                outputWt = inputWt/2.2;
                                txtViewResults.setText(String.format("Converted wt:  %.2f", outputWt));
                            }
                        }
                    } catch (Exception err) {
                        Log.d(Tag,"Error in inner code:" + err.getMessage());
                    }
                }

            });

        } catch (Exception err) {
            Log.d(Tag,"Error in outer code:" + err.getMessage());
        }

    }
}