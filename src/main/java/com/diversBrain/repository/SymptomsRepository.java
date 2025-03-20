package com.diversBrain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.diversBrain.models.Symptoms;
import com.diversBrain.models.User;

public interface SymptomsRepository extends JpaRepository<Symptoms, Integer> {

    Symptoms findById (int id);
    Symptoms findByName (String name);
    boolean existsByName (String name);
    List<Symptoms> findByUser(User user);
}
