package com.immutableant.sfgrecipe.services;

import com.immutableant.sfgrecipe.domain.Recipe;

import java.util.Set;

public interface RecipeService {
    Set<Recipe> getRecipes();
}
