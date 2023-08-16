package com.example.restapi.Configuration;


import com.example.restapi.Entity.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Component
public class TokenProvider {

    private static final String JwtSecret = "djhgcf412313fhahka992321sada";

    public String generateToken(String username) {
        return Jwts.builder()
                .setSubject(username)
                .setExpiration(new Date(new Date().getTime()+3600))
                .signWith(SignatureAlgorithm.HS512, JwtSecret)
                .compact();
    }

}
