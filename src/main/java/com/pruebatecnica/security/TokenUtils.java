package com.pruebatecnica.security;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.lang.Collections;
import io.jsonwebtoken.security.Keys;

public class TokenUtils {
	private static final Logger log = Logger.getLogger(TokenUtils.class);
	private final static String ACCESS_TOKEN_SECRET = "RICARDO!FUENTES@DEV:JAVA_para_PRUEBA-tecnica.1938444721105539!2++18()()";
	private final static Long ACCESS_TOKEN_VALIDITY_SECONDS = 3000000L;
	
	public static String createToken(String name, String email) {
		log.info("createToken name" + name + " | email " + email);
		long expirationTime = ACCESS_TOKEN_VALIDITY_SECONDS * 1000L;
		Date expirationDate = new Date(System.currentTimeMillis() + expirationTime);
		
		Map<String, Object> extra = new HashMap<String, Object>();
		extra.put("name", name);
		
		return Jwts.builder()
				.setSubject(email)
				.setExpiration(expirationDate)
				.addClaims(extra)
				.signWith(Keys.hmacShaKeyFor(ACCESS_TOKEN_SECRET.getBytes()))
				.compact();
	}
	
	public static UsernamePasswordAuthenticationToken getAuthentication(String token) {
		log.info("UsernamePasswordAuthenticationToken");
		try {
			Jws<Claims> jws = Jwts.parser()
				    .setSigningKey(ACCESS_TOKEN_SECRET.getBytes())
				    .build()
				    .parseClaimsJws(token);
		
			//String email = claims.getSubject();
			String email = jws.getBody().getSubject();
			
			return new UsernamePasswordAuthenticationToken(email, null, Collections.emptyList());
			
		}catch(JwtException e) {
			return null;
		}
		
	}
}
