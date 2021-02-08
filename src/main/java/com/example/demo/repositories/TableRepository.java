package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.models.Tablee;

public interface TableRepository extends JpaRepository<Tablee, Integer> {

}
