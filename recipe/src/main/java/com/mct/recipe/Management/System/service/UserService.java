package com.mct.recipe.Management.System.service;

import com.mct.recipe.Management.System.entity.*;
import com.mct.recipe.Management.System.entity.dto.CommentDTO;
import com.mct.recipe.Management.System.repo.ICommentRepo;
import com.mct.recipe.Management.System.repo.IRecipeRepo;
import com.mct.recipe.Management.System.repo.ITokenRepo;
import com.mct.recipe.Management.System.repo.IUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    IUserRepo userRepo;

    @Autowired
    IRecipeRepo recipeRepo;

    @Autowired
    Comment comment;

    @Autowired
    ICommentRepo commentRepo;

    @Autowired
    ITokenRepo tokenRepo;

    public ResponseEntity<String> addUser(User user) {

        String encryptedPassword;
        try {
            encryptedPassword = AuthenticationService.encrypt(user.getUserPassword());
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("internal server issue");
        }
        user.setUserPassword(encryptedPassword);
       userRepo.save(user);
        return ResponseEntity.status(HttpStatus.CREATED).body("user added");
    }

    public ResponseEntity<String> userSignIn(String userEmail, String userPassword) {

        if(isValidUser(userEmail,userPassword)) {
            Optional<User> optionalUser = userRepo.findFirstByUserEmailAddress(userEmail);
            if (tokenRepo.findToken(optionalUser.get().getUserId(), TokenUserType.USER.name()) == null) {

                Token token = new Token(TokenUserType.USER, optionalUser.get().getUserId());
                tokenRepo.save(token);
                return ResponseEntity.status(HttpStatus.OK).body("signIn with token id " + token.getTokenValue());
            } else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("you have already signIn first signOut ");
            }
        }
        else {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credential issue");
            }
            }

    public boolean isValidUser(String eMail, String password){

        Optional<User> optionalUser = userRepo.findFirstByUserEmailAddress(eMail);

        if(optionalUser.isPresent()){
            String encryptedPassword;
            try {
                encryptedPassword = AuthenticationService.encrypt(password);
            } catch (Exception ex) {
                return false;
            }
            return encryptedPassword.equals(optionalUser.get().getUserPassword());
        }else {
            return false;
        }
    }


    public ResponseEntity<String> addComment(CommentDTO commentDTO) {

        if(isValidUser(commentDTO.getUserEmailAddress(), commentDTO.getUserPassword())){

            Optional<Recipe> optionalRecipe = recipeRepo.findById(commentDTO.getRecipeId());

            if (optionalRecipe.isPresent()) {

                Comment userComment = commentDTO.getComment();
                userComment.setRecipe(optionalRecipe.get());
                userComment.setUser(userRepo.findFirstByUserEmailAddress(commentDTO.getUserEmailAddress()).get());

                commentRepo.save(userComment);
                return ResponseEntity.status(HttpStatus.OK).body("comment added");
            } else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("recipe not found");
            }
        }else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("user not found");
        }
    }


    public ResponseEntity<String> userSignOut(String userEmail, String tokenValue) {
        if (userRepo.findFirstByUserEmailAddress(userEmail).isPresent()) {
            User user = userRepo.findFirstByUserEmailAddress(userEmail).get();
            Integer tokenId = tokenRepo.findToken(user.getUserId(),TokenUserType.USER.name());
            tokenRepo.deleteById(tokenId);

            return ResponseEntity.status(HttpStatus.OK).body(" signOut done!!!!!");
        }
        else{
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credential issue");
        }
    }
}
