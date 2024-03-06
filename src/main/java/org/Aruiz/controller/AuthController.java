package org.Aruiz.controller;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.Aruiz.model.User;
import org.Aruiz.service.UserService;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:8100")
@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    UserService userService;

    @PostMapping("/register")
    public ResponseEntity<?> registerOrUpdateUser(@RequestBody User user) {
        User savedUser = userService.createOrUpdateUser(user);
        return ResponseEntity.ok(savedUser);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User user) {
        // Lógica de autenticación y manejo de sesión aquí
        return ResponseEntity.ok("Usuario autenticado correctamente");
    }
}

