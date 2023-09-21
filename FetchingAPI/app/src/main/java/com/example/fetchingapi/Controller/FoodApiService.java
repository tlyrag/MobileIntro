package com.example.fetchingapi.Controller;

import com.example.fetchingapi.Models.Recipe;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface FoodApiService {
    public static final String BASE_URL = "https://api.spoonacular.com";
    @GET("/recipes/informationBulk?ids={id}&includeNutrition=true")
    Call<Recipe> listRecipe(@Path("id") int id);
}
