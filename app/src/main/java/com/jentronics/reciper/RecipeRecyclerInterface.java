package com.jentronics.reciper;

import com.jentronics.reciper.db.Recipe;

public interface RecipeRecyclerInterface {
    void viewRecipe(Recipe recipe);
    void editRecipe(Recipe recipe);
    void processRecipeList(Recipe[] recipes);
}
