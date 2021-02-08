package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.models.Met;
import com.example.demo.models.Plat;

public interface PlatRepository extends JpaRepository<Plat, String> {

}
