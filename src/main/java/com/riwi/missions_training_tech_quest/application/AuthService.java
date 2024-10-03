package com.riwi.missions_training_tech_quest.application;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import com.riwi.missions_training_tech_quest.domain.Roles;
import com.riwi.missions_training_tech_quest.domain.UserEntity;
import com.riwi.missions_training_tech_quest.infrastructure.dtos.RegisterUserDto;

@Service
public class AuthService {

  private final Logger logger = LoggerFactory.getLogger(getClass());

  @Autowired
  private UserRepository userRepository;

  public void registerUser(RegisterUserDto registerUserDto) {
    // Check if user with the email exists
    var foundUser = userRepository.findByEmail(registerUserDto.getEmail());
    if (foundUser.isPresent())
      throw new HttpClientErrorException(HttpStatus.CONFLICT,
          String.format("User with email '%s' already exists", registerUserDto.getEmail()));

    // Create user in the database
    Roles roleToRegister = Roles.valueOf(registerUserDto.getRole());
    var userEntity = UserEntity.builder().email(registerUserDto.getEmail()).fullname(registerUserDto.getFullname())
        .password(registerUserDto.getPassword()).role(roleToRegister).build();

    userEntity.setCreatedBy(userEntity);
    userEntity.setModifiedBy(userEntity);

    var savedUserEntity = userRepository.save(userEntity);
    var message = String.format("User with email %s registered successfully", savedUserEntity.getEmail());
    logger.info(message);
  }

}