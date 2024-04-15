package com.luis.biscoin.controller;

import com.luis.biscoin.model.user.User;
import com.luis.biscoin.repository.UserRepository;
import com.luis.biscoin.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
@CrossOrigin(origins = "http://localhost:4321")
public class AuthenticationController {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    TokenService tokenService;

    @Autowired
    UserRepository userRepository;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody User user) {
        UsernamePasswordAuthenticationToken userCredential=
                new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword());

        Authentication auth = this.authenticationManager.authenticate(userCredential);

        User userAuth = (User) auth.getPrincipal();
        var token = tokenService.generateToken(userAuth);

        var json = "{\"token\": \"" + token + "\"}";
        return ResponseEntity.status(HttpStatus.OK)
                .header("content-type", "application/json")
                .body(json);
    }


    @PostMapping("/register")
    public ResponseEntity register(@RequestBody User user){
        if (this.userRepository.findByUsername(user.getUsername()) != null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\": \"user already exists\" }");
        }

        String password = new BCryptPasswordEncoder().encode(user.getPassword());

        User newUser = new User(user.getUsername(), password, user.getUserRole());

        this.userRepository.save(newUser);

        var token = tokenService.generateToken(newUser);
        return ResponseEntity.status(HttpStatus.CREATED).body(
                "{\"token\":" + token + "}"
        );
    }

}
