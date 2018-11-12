package com.jentronics.reciper;

import android.os.AsyncTask;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jentronics.reciper.db.Recipe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class GetFood2ForkData  extends AsyncTask<String, Integer, String> {
    private String rawJSON;
    private RecipeRecyclerInterface mCallback;

    public void setRecipeRecyclerInterface(RecipeRecyclerInterface mCallback){
        this.mCallback = mCallback;
    }
    @Override
    protected String doInBackground(String... strings) {
        if(strings[0] == null) return null;
        try{
            URL url = new URL("https://www.food2fork.com/api/get?key="
                    + Authorization.AUTH_TOKEN + "&rId=" + strings[0]);
            HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();

            int status = connection.getResponseCode();
            Log.d("Test", "HTTPS response code " + status);

            switch (status){
                case 200:
                case 201:
                    BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                    rawJSON = br.readLine();
                    Log.d("Test", "rawJSON Length: " + rawJSON.length());
                    Log.d("Test", "rawJSON first 256: " + rawJSON.substring(0, 255));
                    break;
            }


        } catch (MalformedURLException e) {
            Log.d("Test", "BAD URL: Unable to connect");
        } catch (IOException e) {
            Log.d("Test", "NO CONNECTION: Unable to connect");
        }

        return rawJSON;

    }

    @Override
    protected void onPostExecute(String result) {
        super.onPostExecute(result);
        Recipe[] recipes;
        try {
            recipes = parseJson(result);
            if(recipes != null ){
                if(mCallback != null && mCallback instanceof RecipeRecyclerInterface) {
                    mCallback.viewRecipe(recipes[0]);
                }
                else {
                    throw new Exception("mCallback not set to OnRecipeComplete");
                }

            }
        }
        catch (Exception e){
            Log.d("Test", e.getMessage());
        }
    }

    private Recipe[] parseJson(String result) {
        GsonBuilder gsonb = new GsonBuilder();
        Gson gson = gsonb.create();

        Recipe[] recipes = null;

        try{
            recipes = gson.fromJson(rawJSON, Recipe[].class);
            Log.d("Test", "First Recipe " + recipes[0].toString());
        }
        catch (Exception e){
            Log.d("Test", e.getMessage());
        }

        return recipes;

    }
}
