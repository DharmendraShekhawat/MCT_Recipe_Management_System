package com.mct.recipe.Management.System.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
@Entity
@Component
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,scope = Comment.class,property = "commentId")

public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer commentId;
    private  String userComment;

    @ManyToOne
    @JoinColumn(name = "fk_recipeId")
    private Recipe recipe;


    @ManyToOne
    @JoinColumn(name = "fk_userId")
    private User user;

}
