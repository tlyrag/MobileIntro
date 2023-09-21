package com.example.fetchingapi;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;

import com.example.fetchingapi.Controller.FoodApiService;
import com.example.fetchingapi.Models.Recipe;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class MainActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i(TAG,"App Starting");
        System.out.println("App Starting");
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(FoodApiService.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        FoodApiService service = retrofit.create(FoodApiService.class);
        try {
            Call<Recipe> requestRecipie = service.listRecipe(642582);
            requestRecipie.enqueue(new Callback<Recipe>() {

                @Override
                public void onResponse(Call<Recipe> call, Response<Recipe> response) {
                    if(!response.isSuccessful()) {
                        Log.i("TAG","Error:"+ response.message());
                    } else {
                        Recipe recipieInfo = response.body();

                        Log.i(TAG,recipieInfo.title);
                    }
                }

                @Override
                public void onFailure(Call<Recipe> call, Throwable t) {
                    Log.e(TAG,"Error: "+ t.getMessage());
                }
            });
        } catch (Exception err) {
            Log.i(TAG,"Error: "+ err.getMessage());
            System.out.println("Error: "+ err.getMessage());
        }


        }





}