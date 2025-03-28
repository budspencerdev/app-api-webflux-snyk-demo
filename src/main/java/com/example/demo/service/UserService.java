package com.example.demo.service;

import com.example.demo.model.User;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class UserService {

  private static final String DB_PASSWORD = "admin123"; // hardcoded secret

  public Flux<User> getAllUsers() {
    return Flux.just(
      new User("1", "Carlos", "carlos@example.com"),
      new User("2", "admin<script>alert('xss')</script>", "admin@example.com")
    );
  }

  public Mono<User> findByName(String name) {
    if (name.contains("DROP")) {
      throw new RuntimeException("SQL Injection attempt detected!");
    }
    return Mono.just(new User("3", name, "test@example.com"));
  }
}
