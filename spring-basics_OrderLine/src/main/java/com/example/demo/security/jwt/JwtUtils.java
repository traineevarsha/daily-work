package com.example.demo.security.jwt;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import com.example.demo.security.service.UserDetailsImplementation;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.UnsupportedJwtException;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtUtils {
    @Value("${com.tek.security.jwtSecret}")
    private String jwtSecret;
    @Value("${com.tek.jwtExpirationMs}")
    private int jwtExpirationMs;
    private Key key() {
        return Keys.hmacShaKeyFor(jwtSecret.getBytes(StandardCharsets.UTF_8));
    }
    public String generateJwtToken(Authentication authentication) {
        UserDetailsImplementation userPrincipal=(UserDetailsImplementation) authentication.getPrincipal();
        return Jwts.builder()
                .setSubject(userPrincipal.getUsername())
                .setIssuedAt(new Date())
                .setExpiration(new Date((new Date()).getTime()+jwtExpirationMs))
                .signWith(key(),SignatureAlgorithm.HS256)
                .compact();
    }
    public String getUserNameFromJwtToken(String token) {
        Claims claims=Jwts.parserBuilder()
                .setSigningKey(key())
                .build()
                .parseClaimsJws(token)
                .getBody();
        return claims.getSubject();
    }
    public boolean validateJwtToken(String authToken) {
        try {
            Jwts.parserBuilder().setSigningKey(key()).build().parseClaimsJws(authToken);
            return true;
        } catch(ExpiredJwtException e) {
            System.out.println("JWT token is expired: "+e.getMessage());
        } catch(UnsupportedJwtException e) {
            System.out.println("JWT token is unsupported: "+e.getMessage());
        } catch(MalformedJwtException e) {
            System.out.println("Invalid JWT token: "+e.getMessage());
        } catch(IllegalArgumentException e) {
            System.out.println("JWT claims string is empty: "+e.getMessage());
        } catch(Exception e) {
            System.out.println("Invalid JWT signature: "+e.getMessage());
        }
        return false;
    }
}