package com.rizomm.filemanager.services;

import com.rizomm.filemanager.config.AppProperties;
import com.rizomm.filemanager.model.UserPrincipal;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import java.util.Date;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class TokenProvider {

  private AppProperties appProperties;

  public TokenProvider(AppProperties appProperties) {
    this.appProperties = appProperties;
  }

  public String createToken(Authentication authentication) {
    UserPrincipal userPrincipal = (UserPrincipal) authentication.getPrincipal();

    Date now = new Date();
    Date expiryDate = new Date(now.getTime() + appProperties.getAuth().getTokenExpirationMsec());

    return Jwts.builder()
        .setSubject(Long.toString(userPrincipal.getId()))
        .setIssuedAt(new Date())
        .setExpiration(expiryDate)
        .signWith(SignatureAlgorithm.HS512, appProperties.getAuth().getTokenSecret())
        .compact();
  }

  public Long getUserIdFromToken(String token) {
    Claims claims = Jwts.parser()
        .setSigningKey(appProperties.getAuth().getTokenSecret())
        .parseClaimsJws(token)
        .getBody();

    return Long.parseLong(claims.getSubject());
  }

  public boolean validateToken(String authToken) {
    try {
      Jwts.parser().setSigningKey(appProperties.getAuth().getTokenSecret()).parseClaimsJws(authToken);
      return true;
    } catch (Exception e) {
      log.error(e.getMessage());
    }
    return false;
  }
}
