package com.jentronics.reciper.db;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class Recipe {
    public Recipe(String recipe_id, String publisher, String f2f_url, String ingredients, String source_url, String image_url, double social_rank, String publisher_url, String title) {
        this.recipe_id = recipe_id;
        this.publisher = publisher;
        this.f2f_url = f2f_url;
        this.ingredients = ingredients;
        this.source_url = source_url;
        this.image_url = image_url;
        this.social_rank = social_rank;
        this.publisher_url = publisher_url;
        this.title = title;
    }

    @PrimaryKey(autoGenerate = true)
    private int uid;

    protected String recipe_id;
    protected String publisher;
    protected String f2f_url;
    protected String ingredients;
    protected String source_url;
    protected String image_url;
    protected double social_rank;
    protected String publisher_url;
    protected String title;


    public String getRecipe_id() {
        return recipe_id;
    }

    public void setRecipe_id(String recipe_id) {
        this.recipe_id = recipe_id;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getF2f_url() {
        return f2f_url;
    }

    public void setF2f_url(String f2f_url) {
        this.f2f_url = f2f_url;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public String getSource_url() {
        return source_url;
    }

    public void setSource_url(String source_url) {
        this.source_url = source_url;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public double getSocial_rank() {
        return social_rank;
    }

    public void setSocial_rank(double social_rank) {
        this.social_rank = social_rank;
    }

    public String getPublisher_url() {
        return publisher_url;
    }

    public void setPublisher_url(String publisher_url) {
        this.publisher_url = publisher_url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    

    @Override
    public String toString() {
        return "Recipe {" +
                "uid=" + uid +
                "recipe_id: '" + recipe_id + "'" +
                "publisher: '" + publisher + "'" +
                "f2f_url: '" + f2f_url + "'" +
                "ingredients: '" + ingredients + "'" +
                "source_url: '" + source_url + "'" +
                "image_url: '" + image_url + "'" +
                "social_rank: '" + social_rank + "'" +
                "publisher_url: '" + publisher_url + "'" +
                "title: '" + title + "'" +
                '}';
    }
}
