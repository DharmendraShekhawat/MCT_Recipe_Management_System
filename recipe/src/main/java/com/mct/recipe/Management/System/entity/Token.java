package com.mct.recipe.Management.System.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.UUID;

@Data
@NoArgsConstructor
@Entity
public class Token {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer tokenId;

    private String tokenValue;

    private LocalDate tokenCreation;

    @Enumerated(value = EnumType.STRING)

    private TokenUserType tokenUserType;

    private Integer tokenUserId;
   public Token(TokenUserType type,Integer id){
        this.tokenUserType = type;
        this.tokenUserId = id;
        this.tokenCreation = LocalDate.now();
        tokenValue = UUID.randomUUID().toString();
    }


}
