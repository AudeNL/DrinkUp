package drinkup.spring.controllers;

import drinkup.spring.domain.Ingredient;
import drinkup.spring.services.ingredient.IngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class IngredientController {

    private IngredientService ingredientService;

    @Autowired
    public void setIngredientService(IngredientService ingredientService) {
        this.ingredientService = ingredientService;
    }

    @RequestMapping(value = "/ingredients", method = RequestMethod.GET)
    public String list(Model model){
        model.addAttribute("ingredients", ingredientService.listAllIngredients());
        return "ingredients";
    }

    @RequestMapping("ingredient/{id}")
    public String showIngredient(@PathVariable int id, Model model){
        model.addAttribute("ingredient", ingredientService.getIngredientById(id));
        return "ingredientshow";
    }

    @RequestMapping("ingredient/edit/{id}")
    public String edit(@PathVariable int id, Model model){
        model.addAttribute("ingredient", ingredientService.getIngredientById(id));
        return "ingredientform";
    }

    @RequestMapping("ingredient/new")
    public String newCustomer(Model model){
        model.addAttribute("ingredient", new Ingredient());
        return "ingredientform";
    }

    @RequestMapping(value = "ingredient", method = RequestMethod.POST)
    public String saveIngredient(Ingredient ingredient){
        ingredientService.saveIngredient(ingredient);
        return "redirect:/ingredient/" + ingredient.getIdIngredient();
    }

    @RequestMapping("ingredient/delete/{id}")
    public String delete(@PathVariable int id){
        ingredientService.deleteIngredient(id);
        return "redirect:/ingredients";
    }

}
