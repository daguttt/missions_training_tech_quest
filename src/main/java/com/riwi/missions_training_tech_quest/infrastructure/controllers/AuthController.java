package com.riwi.missions_training_tech_quest.infrastructure.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.riwi.missions_training_tech_quest.application.AuthService;
import com.riwi.missions_training_tech_quest.infrastructure.dtos.LoginUserDto;
import com.riwi.missions_training_tech_quest.infrastructure.dtos.RegisterUserDto;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/auth")
public class AuthController {

  @Autowired
  private AuthService authService;

  @PostMapping("/register")
  public ResponseEntity<String> registerUser(@Valid @RequestBody RegisterUserDto registerUserDto) {
    authService.registerUser(registerUserDto);
    return ResponseEntity.status(HttpStatus.CREATED).body("User registered successfully");
  }

  @PostMapping("/login")
  public ResponseEntity<String> loginUser(@Valid @RequestBody LoginUserDto loginUserDto) {
    System.err.println();
    return ResponseEntity.ok("User logged in successfully");
  }

}
