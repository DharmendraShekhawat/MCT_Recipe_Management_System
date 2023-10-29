package com.mct.recipe.Management.System.service;

import com.mct.recipe.Management.System.entity.*;
import com.mct.recipe.Management.System.repo.IAdminRepo;
import com.mct.recipe.Management.System.repo.IRecipeRepo;
import com.mct.recipe.Management.System.repo.ITokenRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class RecipeService {

    @Autowired
    IRecipeRepo recipeRepo;

    @Autowired
    IAdminRepo adminRepo;

    @Autowired
    ITokenRepo tokenRepo;

    @Autowired
    AdminService adminService;

    public ResponseEntity<String> addRecipe(String email, String tokenValue, Recipe recipe) {

//        if(adminService.isValidAdmin(email,tokenValue)){
            recipeRepo.save(recipe);
            return ResponseEntity.status(HttpStatus.CREATED).body("recipe added successfully");
//          }
//        else{
//            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credential issue");
//        }
        }

    public ResponseEntity<List<Recipe>> getAllRecipe(String email, String tokenValue) {

        if(adminService.isValidAdmin(email,tokenValue)){
           List<Recipe> recipeList = recipeRepo.findAll();
             return ResponseEntity.status(HttpStatus.OK).body(recipeList);
        }
        else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
        }
    }

    public ResponseEntity<String> updateRecipe(String email, String tokenValue, Recipe recipe) {

        if(adminService.isValidAdmin(email,tokenValue)){
            Recipe oldRecipe = recipeRepo.findById(recipe.getRecipeId()).get();

                        oldRecipe.setRecipeName(recipe.getRecipeName());
                        oldRecipe.setRecipeIngredients(recipe.getRecipeIngredients());
                        return ResponseEntity.status(HttpStatus.OK).body("recipe updated successfully");
                    }
            else {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credential issue");
            }
        }

    public ResponseEntity<String> deleteRecipe(String email, String tokenValue, Integer recipeId) {

        if(adminService.isValidAdmin(email,tokenValue)){

            recipeRepo.deleteById(recipeId);
            return ResponseEntity.status(HttpStatus.OK).body("recipe deleted successfully");
        }
        else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credential issue");
        }
    }

    public ResponseEntity<List<Recipe>> getAllRecipeByUser() {
         List<Recipe> recipeList = recipeRepo.findAll();

         for(Recipe recipe : recipeList){
        List<Comment> commentList = recipe.getComment();
             for(Comment comment : commentList){
                 comment.setUser(null);
             }
         }

         return ResponseEntity.status(HttpStatus.OK).body(recipeList);
    }
}
