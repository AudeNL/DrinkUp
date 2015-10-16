package drinkup.spring.services.ingredient;


import drinkup.spring.domain.Ingredient;

public interface IngredientService {
    Iterable<Ingredient> listAllIngredients();

    Ingredient getIngredientById(int id);

    Ingredient saveIngredient(Ingredient ingredient);

    void deleteIngredient(int id);
}
