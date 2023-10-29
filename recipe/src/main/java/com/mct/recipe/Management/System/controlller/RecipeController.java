package com.mct.recipe.Management.System.controlller;

import com.mct.recipe.Management.System.entity.Recipe;
import com.mct.recipe.Management.System.service.AdminService;
import com.mct.recipe.Management.System.service.RecipeService;
import jakarta.validation.constraints.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RecipeController {

    @Autowired
    RecipeService recipeService;

    @Autowired
    AdminService adminService;

    //-------------- add recipe by authenticated admin----------------------
    @PostMapping("/recipe")
    public ResponseEntity<String> addRecipe(@RequestParam String email,@RequestParam String tokenValue, @RequestBody Recipe recipe){
        return recipeService.addRecipe(email,tokenValue, recipe);
    }

    //-------------- get all recipes by authenticated admin----------------------
    @GetMapping("/recipe")
    public ResponseEntity<List<Recipe>> getAllRecipe(@RequestParam String email, @RequestParam String tokenValue){
        return recipeService.getAllRecipe(email,tokenValue);
    }

    //-------------- add recipe by authenticated admin----------------------
    @PutMapping("/recipe/name/ingredients")
    public ResponseEntity<String> updateRecipe(@RequestParam String email,@RequestParam String tokenValue, @RequestBody Recipe recipe){
        return recipeService.updateRecipe(email,tokenValue, recipe);
    }

    //-------------- delete recipe with recipeId by authenticated admin----------------------
    @DeleteMapping("/recipe")
    public ResponseEntity<String> deleteRecipe(@RequestParam String email,@RequestParam String tokenValue,@PathVariable Integer recipeId){
        return recipeService.deleteRecipe(email,tokenValue, recipeId);
    }

}
