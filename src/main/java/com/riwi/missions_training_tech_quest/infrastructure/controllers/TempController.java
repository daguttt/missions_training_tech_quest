package com.riwi.missions_training_tech_quest.infrastructure.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/some/path")
public class TempController {

  @GetMapping
  public ResponseEntity<TempUserSession> getUserSession() {
    return ResponseEntity.ok().body(new TempUserSession(2l, "Daniel"));

  }
}
