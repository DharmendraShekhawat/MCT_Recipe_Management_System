package com.mct.recipe.Management.System.entity.dto;

import com.mct.recipe.Management.System.entity.Comment;
import lombok.Data;

@Data
public class CommentDTO {

    String userEmailAddress;
    String userPassword;

    Comment comment;

    Integer recipeId;
}
