package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.DessertRequest;
import com.example.demo.dto.DessertResponse;
import com.example.demo.dto.MetRequest;
import com.example.demo.dto.MetResponse;
import com.example.demo.dto.PlatRequest;
import com.example.demo.dto.PlatResponse;
import com.example.demo.models.Dessert;
import com.example.demo.models.Met;
import com.example.demo.models.Plat;
import com.example.demo.services.MetService;
import com.example.demo.services.PlatService;

@RestController
@RequestMapping("/api/plats")

public class PlatController {

	private PlatService service;

	@Autowired
	public PlatController(PlatService service) {
		super();
		this.service = service;
	}

	// ADD A Met
	@PostMapping
	public PlatResponse createMet(@RequestBody PlatRequest request) {
		return service.createPlat(request);
	}
	
	@GetMapping
	public List<Plat> getAllDesserts() {
		return service.getAllPlats();
	}
	
	
	@GetMapping("/{name}")
	public PlatResponse getMet(@PathVariable("name") String name) {
		return service.getPlatById(name);
	}
	
	@DeleteMapping("/{name}")
	public String deleteMetByID(@PathVariable("name") String name) {
		return service.deletePlatById(name);
	}
	
	@PutMapping("/{name}")
	public PlatResponse modifyMetByID(@PathVariable("name") String name,@RequestBody PlatRequest newPlat) {
		return service.modifyPlat(name, newPlat);
	}
	
	




}
