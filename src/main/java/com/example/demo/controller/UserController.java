package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/users")
public class UserController {

  private final UserService service;

  public UserController(UserService service) {
    this.service = service;
  }

  @GetMapping
  public Flux<User> getAll() {
    return service.getAllUsers();
  }

  @GetMapping("/{name}")
  public Mono<User> getByName(@PathVariable String name) {
    return service.findByName(name);
  }
}
