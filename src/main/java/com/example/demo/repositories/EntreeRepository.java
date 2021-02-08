package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.models.Entree;

public interface EntreeRepository extends JpaRepository<Entree, String> {

}
