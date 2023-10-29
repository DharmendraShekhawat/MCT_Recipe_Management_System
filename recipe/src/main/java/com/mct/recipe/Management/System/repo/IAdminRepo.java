package com.mct.recipe.Management.System.repo;

import com.mct.recipe.Management.System.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IAdminRepo extends JpaRepository<Admin,Integer> {


    Optional<Admin> findFirstByAdminEmailAddress(String adminEmail);
}
