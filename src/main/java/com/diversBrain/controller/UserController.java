package com.diversBrain.controller;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.diversBrain.dto.RegisterDto;
import com.diversBrain.models.Role;
import com.diversBrain.models.User;
import com.diversBrain.repository.RoleRepository;
import com.diversBrain.repository.UserRepository;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api")
public class UserController {
    
    private final UserRepository userRepository;
    LocalDateTime dateTime = LocalDateTime.now();
    private final RoleRepository roleRepository;
   


    public UserController(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }


     @GetMapping("/public")
    public String publicApi () {
        return "(\"message\" : \"PUBLIC API\")";
    }

    @GetMapping("/user")
    public String usercApi () {
        return "(\"message\" : \"USER API\")";
    }

    @GetMapping("/admin")
    public String AdminApi () {
        return "(\"message\" : \"ADMIN API\")";
    }

    

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody RegisterDto registerDto) {
        if (userRepository.existsByEmail(registerDto.getEmail())) {
            return new ResponseEntity<>("Username is already taken!", HttpStatus.BAD_REQUEST);
        }

        User user = new User();
        user.setEmail(registerDto.getEmail());
        user.setPassword(registerDto.getPassword());
        user.setFirstname(registerDto.getFirstname());
        user.setLastname(registerDto.getLastname());
        user.setCreatedAt(dateTime);
        user.setRoles(registerDto.getRole()); 
        userRepository.save(user);

        return new ResponseEntity<>("User registered successfully!", HttpStatus.OK);
    }
}

