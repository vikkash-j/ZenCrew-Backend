package com.hrms.zencrew.security;

import java.security.Key;
import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.hrms.zencrew.entity.Employee;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;


@Service
public class JwtService {
	
	@Value("${jwt.secret}")
	private String secretKey;
	
	@Value("${jwt.expiration}")
	private long jwtExperation;
	

	public String generateToken(Employee employee) {
		return Jwts.builder()
				.subject(employee.getEmail())
				.claim("role", employee.getRole().name())
				.issuedAt(new Date())
				.expiration(new Date(System.currentTimeMillis()+jwtExperation))
				.signWith(getSigningKey())
				.compact();
		
	}

	
	public String extractEmail(String token) {
		return extractAllClaims(token).getSubject();
	}
	
	private boolean isTokenValid(String token, UserDetails userDetails) {
		
		final String email = extractEmail(token);
		return email.equals(userDetails.getUsername()) && !isTokenExperied(token);		
		
	}
	
	
	private boolean isTokenExperied(String token) {
		return extractAllClaims(token)
				.getExpiration()
				.before(new Date());
		
	}

	private Claims extractAllClaims(String token) {

        return Jwts.parser()
                .verifyWith(getSigningKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }


	private SecretKey getSigningKey() {
		
		byte[] keyByte = Decoders.BASE64.decode(secretKey);
		
		return Keys.hmacShaKeyFor(keyByte);
	}
	


}