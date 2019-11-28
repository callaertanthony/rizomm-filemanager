package com.rizomm.filemanager.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/oauth2")
public class Oauth2Controller {

  @PostMapping("/authorize/github")
  public ResponseEntity authorizeGithub() {
    return ResponseEntity.ok(null);
  }

}
