package com.riwi.missions_training_tech_quest.infrastruture.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.riwi.missions_training_tech_quest.infrastruture.dtos.LoginUserDto;
import com.riwi.missions_training_tech_quest.infrastruture.dtos.RegisterUserDto;

import jakarta.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/auth")
public class AuthController {

  @PostMapping("/register")
  public ResponseEntity<String> registerUser(@Valid @RequestBody RegisterUserDto registerUserDto) {
    return ResponseEntity.ok("User registered successfully");
  }

  @PostMapping("/login")
  public ResponseEntity<String> loginUser(@Valid @RequestBody LoginUserDto loginUserDto) {
    System.err.println();
    return ResponseEntity.ok("User logged in successfully");
  }

}
