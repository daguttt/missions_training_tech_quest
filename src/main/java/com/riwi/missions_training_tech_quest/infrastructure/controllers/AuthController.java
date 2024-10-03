package com.riwi.missions_training_tech_quest.infrastructure.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.riwi.missions_training_tech_quest.application.AuthService;
import com.riwi.missions_training_tech_quest.infrastructure.dtos.LoginUserDto;
import com.riwi.missions_training_tech_quest.infrastructure.dtos.ProblemDetailWithErrors;
import com.riwi.missions_training_tech_quest.infrastructure.dtos.RegisterResponseDto;
import com.riwi.missions_training_tech_quest.infrastructure.dtos.RegisterUserDto;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/auth")
public class AuthController {

  @Autowired
  private AuthService authService;

  @Operation(summary = "Register user", description = "Description: Register a new user")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "201", description = "User registration is successful", content = {
          @Content(mediaType = "application/json", schema = @Schema(implementation = RegisterResponseDto.class))
      }),
      @ApiResponse(responseCode = "400", description = "The request body has invalid values", content = {
          @Content(mediaType = "application/json", schema = @Schema(implementation = ProblemDetailWithErrors.class))
      }),
      @ApiResponse(responseCode = "409", description = "User already exists", content = {
          @Content(mediaType = "application/json", schema = @Schema(implementation = ProblemDetail.class))
      }),
  })
  @PostMapping("/register")
  public ResponseEntity<RegisterResponseDto> registerUser(@Valid @RequestBody RegisterUserDto registerUserDto) {
    authService.registerUser(registerUserDto);
    RegisterResponseDto registerResponseDto = new RegisterResponseDto(HttpStatus.CREATED.value(),
        "User registered successfully");
    return ResponseEntity.status(HttpStatus.CREATED).body(registerResponseDto);
  }

  @PostMapping("/login")
  public ResponseEntity<String> loginUser(@Valid @RequestBody LoginUserDto loginUserDto) {
    System.err.println();
    return ResponseEntity.ok("User logged in successfully");
  }

}
