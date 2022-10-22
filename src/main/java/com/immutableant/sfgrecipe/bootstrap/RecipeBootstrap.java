package com.immutableant.sfgrecipe.bootstrap;

import com.immutableant.sfgrecipe.domain.*;
import com.immutableant.sfgrecipe.repositories.CategoryRepository;
import com.immutableant.sfgrecipe.repositories.RecipeRepository;
import com.immutableant.sfgrecipe.repositories.UnitOfMeasureRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class RecipeBootstrap implements ApplicationListener<ContextRefreshedEvent> {
  private final CategoryRepository categoryRepository;
  private final RecipeRepository recipeRepository;
  private final UnitOfMeasureRepository unitOfMeasureRepository;

  public RecipeBootstrap(
      CategoryRepository categoryRepository,
      RecipeRepository recipeRepository,
      UnitOfMeasureRepository unitOfMeasureRepository) {
    this.categoryRepository = categoryRepository;
    this.recipeRepository = recipeRepository;
    this.unitOfMeasureRepository = unitOfMeasureRepository;
  }

  private List<Recipe> getRecipe() {
    List<Recipe> recipes = new ArrayList<>(2);

    Optional<UnitOfMeasure> eachUomOptional = unitOfMeasureRepository.findByUom("Each");

    if (!eachUomOptional.isPresent()) {
      throw new RuntimeException(("Expected UOM Not Found"));
    }

    Optional<UnitOfMeasure> tablespoonUomOptional = unitOfMeasureRepository.findByUom("Tablespoon");

    if (!tablespoonUomOptional.isPresent()) {
      throw new RuntimeException(("Expected UOM Not Found"));
    }

    Optional<UnitOfMeasure> teaspoonUomOptional = unitOfMeasureRepository.findByUom("Teaspoon");

    if (!teaspoonUomOptional.isPresent()) {
      throw new RuntimeException(("Expected UOM Not Found"));
    }

    Optional<UnitOfMeasure> dashUomOptional = unitOfMeasureRepository.findByUom("Dash");

    if (!dashUomOptional.isPresent()) {
      throw new RuntimeException(("Expected UOM Not Found"));
    }

    Optional<UnitOfMeasure> pintUomOptional = unitOfMeasureRepository.findByUom("Pint");

    if (!pintUomOptional.isPresent()) {
      throw new RuntimeException(("Expected UOM Not Found"));
    }

    Optional<UnitOfMeasure> cupsUomOptional = unitOfMeasureRepository.findByUom("Cups");

    if (!cupsUomOptional.isPresent()) {
      throw new RuntimeException(("Expected UOM Not Found"));
    }

    UnitOfMeasure eachUom = eachUomOptional.get();
    UnitOfMeasure tablespoonUom = tablespoonUomOptional.get();
    UnitOfMeasure teaspoonUom = teaspoonUomOptional.get();
    UnitOfMeasure dashUom = dashUomOptional.get();
    UnitOfMeasure pintUom = pintUomOptional.get();
    UnitOfMeasure cupsUom = cupsUomOptional.get();

    Optional<Category> americanCategoryOptional = categoryRepository.findByDescription("American");

    if (!americanCategoryOptional.isPresent()) {
      throw new RuntimeException("Expected Category Not found");
    }

    Optional<Category> mexicanCategoryOptional = categoryRepository.findByDescription("Mexican");

    if (!mexicanCategoryOptional.isPresent()) {
      throw new RuntimeException("Expected Category Not found");
    }

    Category americanCategory = americanCategoryOptional.get();
    Category mexicanCategory = mexicanCategoryOptional.get();

    Recipe guacRecipe = new Recipe();
    guacRecipe.setDescription("Perfect Guacamole");
    guacRecipe.setPrepTime(10);
    guacRecipe.setCooktime(0);
    guacRecipe.setDifficulty(Difficulty.EASY);
    guacRecipe.setDirections("I put the directions here");

    Notes guacNotes = new Notes();
    guacNotes.setRecipeNotes("Notes of the guac");

    guacRecipe.setNotes(guacNotes);

    guacRecipe.addIngredient(new Ingredient("ripe avocados", new BigDecimal(2), eachUom));
    guacRecipe
        .getIngredients()
        .add(new Ingredient("Kosher salt", new BigDecimal(".5"), teaspoonUom));
    guacRecipe
        .getIngredients()
        .add(new Ingredient("fresh lime juice or lemon juice", new BigDecimal(2), tablespoonUom));
    guacRecipe
        .getIngredients()
        .add(
            new Ingredient(
                "minced red onion or thinly sliced green onion", new BigDecimal(2), tablespoonUom));
    guacRecipe
        .getIngredients()
        .add(
            new Ingredient(
                "serrano chiles, stems and seeds removed, minced", new BigDecimal(2), eachUom));
    guacRecipe.addIngredient(new Ingredient("Cilantro", new BigDecimal(2), tablespoonUom));
    guacRecipe
        .getIngredients()
        .add(new Ingredient("freshly grated black pepper", new BigDecimal(2), dashUom));
    guacRecipe
        .getIngredients()
        .add(
            new Ingredient(
                "ripe tomato, seeds and pulp removed, chopped", new BigDecimal(".5"), eachUom));

    guacRecipe.getCategories().add(americanCategory);
    guacRecipe.getCategories().add(mexicanCategory);

    recipes.add(guacRecipe);

    Recipe tacosRecipe = new Recipe();
    tacosRecipe.setDescription("Spicy Grilled Chicken Taco");
    tacosRecipe.setCooktime(9);
    tacosRecipe.setPrepTime(20);
    tacosRecipe.setDifficulty(Difficulty.MODERATE);

    tacosRecipe.setDirections("More directions");

    Notes tacosNotes = new Notes();
    tacosNotes.setRecipeNotes("Notes of the tacos");

    tacosRecipe.setNotes(tacosNotes);


    tacosRecipe.addIngredient(new Ingredient("Ancho Chili Powder", new BigDecimal(2), tablespoonUom));
    tacosRecipe.addIngredient(new Ingredient("Dried Oregano", new BigDecimal(1), teaspoonUom));
    tacosRecipe.addIngredient(new Ingredient("Dried Cumin", new BigDecimal(1), teaspoonUom));
    tacosRecipe.addIngredient(new Ingredient("Sugar", new BigDecimal(1), teaspoonUom));
    tacosRecipe.addIngredient(new Ingredient("Salt", new BigDecimal(".5"), teaspoonUom));
    tacosRecipe.addIngredient(new Ingredient("Clove of Garlic, Chopped", new BigDecimal(1), eachUom));
    tacosRecipe.addIngredient(new Ingredient("finely grated orange zest", new BigDecimal(1), tablespoonUom));
    tacosRecipe.addIngredient(new Ingredient("fresh-squeezed orange juice", new BigDecimal(3), tablespoonUom));
    tacosRecipe.addIngredient(new Ingredient("Olive Oil", new BigDecimal(2), tablespoonUom));
    tacosRecipe.addIngredient(new Ingredient("boneless chicken thighs", new BigDecimal(4), tablespoonUom));
    tacosRecipe.addIngredient(new Ingredient("small corn tortillas", new BigDecimal(8), eachUom));
    tacosRecipe.addIngredient(new Ingredient("packed baby arugula", new BigDecimal(3), cupsUom));
    tacosRecipe.addIngredient(new Ingredient("medium ripe avocados, sliced", new BigDecimal(2), eachUom));
    tacosRecipe.addIngredient(new Ingredient("radishes, thinly sliced", new BigDecimal(4), eachUom));
    tacosRecipe.addIngredient(new Ingredient("cherry tomatoes, halved", new BigDecimal(".5"), pintUom));
    tacosRecipe.addIngredient(new Ingredient("red onion, thinly sliced", new BigDecimal(".25"), eachUom));
    tacosRecipe.addIngredient(new Ingredient("Roughly chopped cilantro", new BigDecimal(4), eachUom));
    tacosRecipe.addIngredient(new Ingredient("cup sour cream thinned with 1/4 cup milk", new BigDecimal(4), cupsUom));
    tacosRecipe.addIngredient(new Ingredient("lime, cut into wedges", new BigDecimal(4), eachUom));

    tacosRecipe.getCategories().add(americanCategory);
    tacosRecipe.getCategories().add(mexicanCategory);

    recipes.add(tacosRecipe);
    return recipes;
  }

  @Override
  public void onApplicationEvent(ContextRefreshedEvent event) {
    recipeRepository.saveAll(getRecipe());
  }
}
