package com.mct.recipe.Management.System.repo;

import com.mct.recipe.Management.System.entity.Token;
import com.mct.recipe.Management.System.entity.TokenUserType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ITokenRepo extends JpaRepository<Token, Integer> {

@Query(value = "select token_id from token where token_user_id =:id AND token_user_type =:type", nativeQuery = true)
   Integer findToken(Integer id, String type);

   @Query(value = "select token_value from token where token_user_id =:adminId AND token_user_type =:userType", nativeQuery = true)
   String findTokenValueByTokenUserIdAndTokenUserType(Integer adminId, String userType);


}
