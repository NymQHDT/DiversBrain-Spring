// package com.diversBrain.service;

// import java.time.LocalDateTime;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;

// import com.diversBrain.dto.RegisterDto;
// import com.diversBrain.models.Role;
// import com.diversBrain.models.User;
// import com.diversBrain.repository.RoleRepository;
// import com.diversBrain.repository.UserRepository;

// @Service
// public class AuthService {
    
//     @Autowired
//     private UserRepository userRepository;
    
//     @Autowired
//     private RoleRepository roleRepository;
    
    
//     public User registerUser(RegisterDto request) {
//         // Vérifier si l'email existe déjà
//         if (userRepository.existsByEmail(request.getEmail())) {
//             throw new RuntimeException("Email déjà utilisé");
//         }
        
//         // Trouver le rôle approprié
//         Role role = roleRepository.findByName(request.getRole())
//                 .orElseThrow(() -> new RuntimeException("Rôle non trouvé"));
        
//         // Créer l'utilisateur
//         User user = new User();
//         user.setFirstname(request.getFirstname());
//         user.setLastname(request.getLastname());
//         user.setEmail(request.getEmail());
//         user.setPassword(request.getPassword());
//         user.setPhone(request.getPhone());
//         user.setRole(role);
//         user.setCreatedAt(LocalDateTime.now());
//         user.setActive(true);
        
//         // Si c'est un professionnel, ajouter les infos supplémentaires
//         if ("PROFESSIONAL".equals(request.getRole())) {
//             user.setCompanyName(request.getCompanyName());
//             user.setSiret(request.getSiret());
//             user.setAddress(request.getAddress());
            
//             // Validation des champs professionnels
//             if (request.getCompanyName() == null || request.getCompanyName().trim().isEmpty()) {
//                 throw new RuntimeException("Le nom de l'entreprise est obligatoire pour un compte professionnel");
//             }
//             if (request.getSiret() == null || !request.getSiret().matches("\\d{14}")) {
//                 throw new RuntimeException("Le SIRET doit comporter 14 chiffres");
//             }
//             if (request.getAddress() == null || request.getAddress().trim().isEmpty()) {
//                 throw new RuntimeException("L'adresse est obligatoire pour un compte professionnel");
//             }
//         }
        
//         return userRepository.save(user);
//     }
// }