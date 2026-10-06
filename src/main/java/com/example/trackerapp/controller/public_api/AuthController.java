package com.example.trackerapp.controller.public_api;

import com.example.trackerapp.entity.User;
import com.example.trackerapp.entity.UserRole;
import com.example.trackerapp.entity.dto.AuthDto;
import com.example.trackerapp.security.JwtCore;
import com.example.trackerapp.service.UserService;
import org.apache.catalina.Authenticator;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserService userService;
    private final JwtCore jwtCore;
    private final AuthenticationManager authenticationManager;

    public AuthController(UserService userService, JwtCore jwtCore, AuthenticationManager authenticationManager) {
        this.userService = userService;
        this.jwtCore = jwtCore;
        this.authenticationManager = authenticationManager;
    }

    @PostMapping("/signup")
    public ResponseEntity<?> createUserAccount(@RequestBody AuthDto authDto){
        if(userService.existsUserByLogin(authDto.getLogin())){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Choose different login");
        }
        User newUser = userService.createNewUser(authDto.getLogin(), authDto.getPassword(), UserRole.USER);
        userService.save(newUser);
        return ResponseEntity.ok("Success");
    }
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthDto authDto) {
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authDto.getLogin(), authDto.getPassword())
            );
            String token = jwtCore.generateToken(authentication);
            return ResponseEntity.ok(token);
        } catch (BadCredentialsException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid login or password");
        }
    }
    }


