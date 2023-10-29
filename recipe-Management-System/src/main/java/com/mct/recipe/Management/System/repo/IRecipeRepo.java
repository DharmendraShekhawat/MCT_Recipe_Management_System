package com.mct.recipe.Management.System.repo;

import com.mct.recipe.Management.System.entity.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRecipeRepo extends JpaRepository<Recipe,Integer> {


}
