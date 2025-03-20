package com.diversBrain.controller;

import com.diversBrain.dto.SymptomsDTO;
import com.diversBrain.models.Symptoms;
import com.diversBrain.models.User;
import com.diversBrain.repository.SymptomsRepository;
import com.diversBrain.repository.UserRepository;
import com.diversBrain.service.SymptomService;

import java.time.Duration;
import java.util.List;
import java.util.Map;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/api/symptoms")
@CrossOrigin(origins = "*")
public class SymptomsController {

    @Autowired
    private final SymptomsRepository symptomsRepository;
    private final UserRepository userRepository;
    private SymptomService symptomService;
    

    public SymptomsController(SymptomsRepository symptomsRepository, UserRepository userRepository) {
        this.symptomsRepository = symptomsRepository;
        this.userRepository = userRepository;
    }


    @PostMapping
    public ResponseEntity<Map<String, String>> symptoms (@RequestBody SymptomsDTO symptomsDto) {
        
        Duration duration = null;
        if (symptomsDto.getLasting() != null) {
            duration = Duration.ofHours(symptomsDto.getLasting().getHours())
                              .plusMinutes(symptomsDto.getLasting().getMinutes());
        }
        
        Symptoms symptoms = new Symptoms();
        symptoms.setName(symptomsDto.getName());
        symptoms.setDate(symptomsDto.getDate());
        symptoms.setLasting(duration);        
        symptoms.setIntensity(symptomsDto.getIntensity());
        symptoms.setTriggers(symptomsDto.getTriggers());
        symptoms.setCalming(symptomsDto.getCalming());
        symptoms.setDescription(symptomsDto.getDescription());
        symptomsRepository.save(symptoms);


        return ResponseEntity.ok(Map.of("message", "Symptoms registered successfully!"));    
    }
    
     @PostMapping
    public ResponseEntity<Symptoms> createSymptom(@RequestBody Symptoms symptom, Authentication authentication) {
        // Récupérer l'utilisateur connecté à partir du contexte de sécurité
        String username = user.getName();
        User currentUser = userRepository.findByUsername(username);
        
        Symptoms savedSymptom = symptomService.saveSymptom(symptom, currentUser);
        return ResponseEntity.ok(savedSymptom);
    }
    
    @GetMapping("/my")
    public ResponseEntity<List<Symptoms>> getMySymptoms(Authentication authentication) {
        String username = authentication.getName();
        User currentUser = userRepository.findByUsername(username);
        
        List<Symptoms> symptoms = symptomService.getSymptomsByUser(currentUser);
        return ResponseEntity.ok(symptoms);
    }


    
}