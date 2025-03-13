package com.diversBrain.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.diversBrain.models.ERole;
import com.diversBrain.models.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {


    Role findByName(ERole roleEnum); 
  
}