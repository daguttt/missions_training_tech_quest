package com.riwi.missions_training_tech_quest.infrastructure.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public abstract class ApiResponseDto {
  private Integer status;
  private String message;
}
