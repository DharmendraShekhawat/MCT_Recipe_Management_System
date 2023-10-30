package com.mct.recipe.Management.System.controlller;

import com.mct.recipe.Management.System.entity.Recipe;
import com.mct.recipe.Management.System.entity.User;
import com.mct.recipe.Management.System.entity.dto.CommentDTO;
import com.mct.recipe.Management.System.service.RecipeService;
import com.mct.recipe.Management.System.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Validated
@RestController
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    RecipeService recipeService;


    //------------- user signUp------------------------------------
    @PostMapping("/user")
    public ResponseEntity<String> addUser(@Valid @RequestBody User user){
        return userService.addUser(user);
    }

    //-------------random user can get list of recipes-------------
    @GetMapping("/randomUser/recipes")
    public ResponseEntity<List<Recipe>> getAllRecipe(){
        return recipeService.getAllRecipeByUser();
    }

    //-------------- user SignIn------------------------
    @PostMapping("/user/signIn")
    public ResponseEntity<String> userSignIn(@Valid @RequestParam String userEmail,@Valid @RequestParam String userPassword) {
        return userService.userSignIn(userEmail,userPassword);
    }

    //-------------- user SignOut------------------------
    @DeleteMapping("/user/signOut")
    public ResponseEntity<String> userSignOut(@Valid @RequestParam String userEmail,@Valid @RequestParam String tokenValue) {
        return userService.userSignOut(userEmail,tokenValue);
    }

    @PostMapping("/user/comment")
    public ResponseEntity<String> addComment(@Valid @RequestBody CommentDTO commentDTO){
        return userService.addComment(commentDTO);
    }


}
