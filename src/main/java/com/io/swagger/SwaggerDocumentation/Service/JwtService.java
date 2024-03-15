package com.io.swagger.SwaggerDocumentation.Service;

import com.io.swagger.SwaggerDocumentation.model.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.security.Key;
import java.util.Date;
import java.util.function.Function;

@Service
public class JwtService {

    private final String SECRET_KEY="6f43d50c571b6d850395fb83380c45b44e01a764db13ab47909e496756771c58";

    public String extractUserName(String token){
        return extractClaims(token,Claims::getSubject);
    }
    public <T> T extractClaims(String token, Function<Claims,T>resolver){
        Claims claims = extractAll(token);
        return resolver.apply(claims);
    }
    public boolean isValid(String token, UserDetails user){
        String userName = extractUserName(token);
        return userName.equals(user.getUsername()) && isTokenExpired(token);

    }

    private boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    private Date extractExpiration(String token) {
        return extractClaims(token,Claims::getExpiration);
    }

    public String generateToke(User user){
        String token = Jwts
                .builder()
                .subject(user.getUsername())
                .issuedAt((new Date(System.currentTimeMillis())))
                .expiration(new Date(System.currentTimeMillis()+24*60*60*1000))
                .signWith(getSigingKey()).compact();
        return token;
    }

    private SecretKey getSigingKey() {
        byte[]keyBytes = Decoders.BASE64URL.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    private Claims extractAll(String token){
        return  Jwts
                .parser()
                .verifyWith(getSigingKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }



}
