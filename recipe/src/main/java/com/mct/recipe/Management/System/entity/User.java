package com.mct.recipe.Management.System.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

import java.util.List;

@Data
@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,scope = User.class,property = "userId")
public class User {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Integer userId;

   @NotBlank
   private String userName;

   @Pattern(regexp = "^[a-z0-9]+@gmail\\.com$", message = "use valid email address")
   private String userEmailAddress;

   private String userPassword;


}
