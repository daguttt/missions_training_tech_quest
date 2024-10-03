package com.riwi.missions_training_tech_quest.infrastructure.dtos;

import com.riwi.missions_training_tech_quest.domain.Roles;
import com.riwi.missions_training_tech_quest.infrastructure.validators.enums.ValidEnum;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class RegisterUserDto {
  @Schema(example = "John Doe", description = "Fullname of the user")
  @NotBlank(message = "Fullname cannot be blank")
  private String fullname;

  @Schema(example = "john@doe.com", description = "Email of the user")
  @NotBlank(message = "Email cannot be blank")
  @Pattern(
      regexp = "[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?",
      message = "Email must be valid")
  private String email;

  @Schema(example = "JohnDoe1234*", description = "Password of the user")
  @NotBlank(message = "Password cannot be blank")
  @Pattern(regexp = "(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d @$!%*?&]{8,}$",
      message = "Password must include at least one uppercase letter, one lowercase letter, one number, and one special character")
  private String password;

  @Schema(example = "STUDENT", description = "Role of the user")
  @NotBlank(message = "Role cannot be blank")
  @ValidEnum(enumClass = Roles.class, message = "Role must be either 'STUDENT', 'TEACHER' or 'ADMIN")
  private String role;

}
