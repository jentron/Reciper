package com.jentronics.reciper.db;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

@Dao
public interface RecipeDAO {

    @Query("select * from recipe")
    LiveData<List<Recipe>> getAll();

    @Query("select * from recipe where recipe_id = :id")
    List<Recipe> loadByID(String id);

    @Query("select * from recipe where uid = :uid LIMIT 1")
    Recipe getByUID(int uid);

    @Delete
    void delete(Recipe recipe);

    @Update
    void update(Recipe recipe);

    @Insert
    void insert(Recipe... recipes);

    @Query("delete from recipe")
    void deleteAll();
}
