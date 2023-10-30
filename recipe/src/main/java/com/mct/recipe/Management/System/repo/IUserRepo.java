package com.mct.recipe.Management.System.repo;

import com.mct.recipe.Management.System.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IUserRepo extends JpaRepository<User,Integer> {


    Optional<User> findFirstByUserEmailAddress(String eMail);
}
