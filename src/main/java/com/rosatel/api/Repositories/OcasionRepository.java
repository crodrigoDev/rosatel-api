package com.rosatel.api.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rosatel.api.Models.Ocasion;

public interface OcasionRepository extends JpaRepository<Ocasion, Integer> {
    
}
