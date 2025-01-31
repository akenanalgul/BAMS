package com.example.BAMS.security;

import com.example.BAMS.model.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;
import java.util.Date;


@Component
public class JwtUtil {
    private final String SECRET_KEY="secret"; // TODO:Daha sonra .env klasörüne koyulacak.
    private final long EXPIRATION_TIME=86400000;

    public String generateToken(User user){
        return Jwts.builder()
                .setSubject(user.getEmail())
                .claim("role",user.getRole().name())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis()+ EXPIRATION_TIME)) // valid for 1 day
                .signWith(SignatureAlgorithm.HS256,SECRET_KEY)
                .compact();
}
/*
    public String extractEmail(String token){
        return getClaims(token).getSubject();
    }
    public boolean validateToken(String token){
        return getClaims(token).getExpiration().after(new Date());
    }
    private Claims getClaims(String token){
        return Jwts.parser()
                .setSigningKey(SECRET_KEY)
                .parseClaimsJws(token)
                .getBody();
    }

 */
}

