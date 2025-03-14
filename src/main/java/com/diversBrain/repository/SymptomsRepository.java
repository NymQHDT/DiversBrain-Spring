package com.diversBrain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.diversBrain.models.Symptoms;

public interface SymptomsRepository extends JpaRepository<Symptoms, Integer> {

    Symptoms findById (int id);
    Symptoms findByName (String name);
    boolean existsByName (String name);
}
