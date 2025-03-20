package com.diversBrain.controller;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.diversBrain.dto.LoginDTO;
import com.diversBrain.dto.RegisterDTO;
import com.diversBrain.models.ERole;
import com.diversBrain.models.Role;
import com.diversBrain.models.User;
import com.diversBrain.repository.RoleRepository;
import com.diversBrain.repository.SymptomsRepository;
import com.diversBrain.repository.UserRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private final UserRepository userRepository;
    LocalDateTime dateTime = LocalDateTime.now();
    private final RoleRepository roleRepository;
    private final SymptomsRepository symptomsRepository;

    public UserController(UserRepository userRepository, RoleRepository roleRepository, SymptomsRepository symptomsRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.symptomsRepository = symptomsRepository;
    }

    // @GetMapping("/public")
    // public String publicApi () {
    // return "(\"message\" : \"PUBLIC API\")";
    // }

    // @GetMapping("/user")
    // public String usercApi () {
    // return "(\"message\" : \"USER API\")";
    // }

    // @GetMapping("/admin")
    // public String AdminApi () {
    // return "(\"message\" : \"ADMIN API\")";
    // }

    @PostMapping("/register")
    public ResponseEntity<Map<String, String>> register(@RequestBody RegisterDTO registerDto) {
        if (userRepository.existsByEmail(registerDto.getEmail())) {
            return new ResponseEntity<>(Map.of("error", "Username is already taken!"), HttpStatus.BAD_REQUEST);
        }
    
        User user = new User();
        user.setEmail(registerDto.getEmail());
        user.setPassword(registerDto.getPassword());
        user.setFirstname(registerDto.getFirstname());
        user.setLastname(registerDto.getLastname());
        user.setCreatedAt(LocalDateTime.now());
    
        String roleName = registerDto.getRole();
        ERole roleEnum = switch (roleName) {
            case "admin" -> ERole.ADMIN;
            case "professional" -> ERole.PROFESSIONNAL;
            default -> ERole.PERSON;
        };
    
        Role userRole = roleRepository.findByName(roleEnum);
        if (userRole == null) {
            return new ResponseEntity<>(Map.of("error", "Role not found"), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    
        if ("professional".equals(roleName)) {
            user.setCompanyName(registerDto.getCompanyName());
            user.setSiret(registerDto.getSiret());
            user.setAddress(registerDto.getAddress());
            user.setPhone(registerDto.getPhone());
        }
    
        user.setRole(userRole);
        userRepository.save(user);
    

        return ResponseEntity.ok(Map.of("message", "User registered successfully!"));
    }
        @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginDTO loginDTO) {
        loginDTO.getEmail();
        loginDTO.getPassword();
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/symptoms")
    public ResponseEntity<Map<String, String>> symptoms() {
        return ResponseEntity.ok(Map.of("message", "Symptoms registered successfully!"));
    }
}
