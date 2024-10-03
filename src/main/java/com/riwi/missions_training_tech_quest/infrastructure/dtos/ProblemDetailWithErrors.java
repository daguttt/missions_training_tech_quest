package com.riwi.missions_training_tech_quest.infrastructure.dtos;

import org.springframework.http.ProblemDetail;

import lombok.Getter;

@Getter
public class ProblemDetailWithErrors extends ProblemDetail {
  private ProblemDetailFieldError[] errors;

  public ProblemDetailWithErrors(int status) {
    super(status);
  }
}
