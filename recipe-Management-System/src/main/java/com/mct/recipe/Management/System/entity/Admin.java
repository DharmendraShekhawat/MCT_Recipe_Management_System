package com.mct.recipe.Management.System.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import lombok.NonNull;

import java.util.List;

@Data
@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,scope = Admin.class,property = "adminId")
public class Admin {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Integer adminId;

   @NotBlank
   private String adminName;

   @Pattern(regexp = "^[a-z0-9]+@admin\\.com$")
   private String adminEmailAddress;

   private String adminPassword;



}
