package com.diversBrain.controller;

import com.diversBrain.dto.SymptomsDTO;
import com.diversBrain.models.Symptoms;
import com.diversBrain.repository.SymptomsRepository;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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

    public SymptomsController(SymptomsRepository symptomsRepository) {
        this.symptomsRepository = symptomsRepository;
    }

    @PostMapping
    public ResponseEntity<Map<String, String>> symptoms (@RequestBody SymptomsDTO symptomsDto) {
        if (symptomsRepository.existsByName(symptomsDto.getName())) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        
        Symptoms symptoms = new Symptoms();
        symptoms.setName(symptomsDto.getName());
        symptoms.setDate(symptomsDto.getDate());
        symptoms.setLasting(symptomsDto.getLasting());
        symptoms.setIntensity(symptomsDto.getIntensity());
        symptoms.setTriggers(symptomsDto.getTriggers());
        symptoms.setCalming(symptomsDto.getCalming());
        symptoms.setDescription(symptomsDto.getDescription());
        symptomsRepository.save(symptoms);


        return ResponseEntity.ok(Map.of("message", "Symptoms registered successfully!"));    
    }
    


    
}