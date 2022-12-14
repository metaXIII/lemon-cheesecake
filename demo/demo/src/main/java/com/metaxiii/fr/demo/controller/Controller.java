package com.metaxiii.fr.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class Controller {

  @GetMapping("/")
  Mono<ResponseEntity<String>> welcome() {
    return Mono.just(ResponseEntity.ok("You're connected"));
  }
}
