package com.diversBrain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.diversBrain.models.User;

public interface UserRepository extends JpaRepository<User, Long> {

    boolean existsByEmail(String email);


}
