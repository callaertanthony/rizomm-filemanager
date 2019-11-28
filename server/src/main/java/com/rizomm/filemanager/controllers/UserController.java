package com.rizomm.filemanager.controllers;

import com.rizomm.filemanager.business.entities.User;
import com.rizomm.filemanager.business.services.UserService;
import java.security.Principal;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

  @Autowired
  private UserService userService;

  @GetMapping
  public ResponseEntity<List<User>> getAll() {
    return ResponseEntity.ok(userService.findAll());
  }

  @GetMapping("/me")
  public String sayHello(Principal principal) {
    return "Hello, " + principal.getName();
  }

}
