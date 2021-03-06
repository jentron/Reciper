package com.jentronics.reciper.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

@Database(entities = {Recipe.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {

    private static AppDatabase instance;
// singleton pattern
    public static AppDatabase getInstance(Context context){
        if (instance != null ) return instance;

        instance = Room.databaseBuilder(context, AppDatabase.class, "appdata").build();
        return instance;
    }

    public abstract RecipeDAO recipeDAO();

}
