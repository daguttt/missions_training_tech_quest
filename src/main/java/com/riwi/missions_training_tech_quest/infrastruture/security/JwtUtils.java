package com.riwi.missions_training_tech_quest.infrastruture.security;

import org.springframework.beans.factory.annotation.Value;

public class JwtUtils {

  @Value("${jwt.secret-key}")
  private String jwtSecretKey;

  @Value("${jwt.expiration}")
  private Long jwtExpiration;

}
