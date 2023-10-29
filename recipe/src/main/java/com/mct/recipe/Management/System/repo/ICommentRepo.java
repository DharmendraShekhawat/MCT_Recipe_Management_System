package com.mct.recipe.Management.System.repo;

import com.mct.recipe.Management.System.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICommentRepo extends JpaRepository<Comment,Integer> {



}
