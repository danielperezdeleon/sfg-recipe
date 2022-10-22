package com.immutableant.sfgrecipe.controllers;

import com.immutableant.sfgrecipe.domain.Category;
import com.immutableant.sfgrecipe.domain.UnitOfMeasure;
import com.immutableant.sfgrecipe.repositories.CategoryRepository;
import com.immutableant.sfgrecipe.repositories.UnitOfMeasureRepository;
import com.immutableant.sfgrecipe.services.RecipeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
public class IndexController {

    private final RecipeService recipeService;

    public IndexController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @RequestMapping({"","/","/index"})
    public String getindexPage(Model model) {
        model.addAttribute("recipes", recipeService.getRecipes());

        return "index";
    }
}
