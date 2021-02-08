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
import com.example.demo.dto.EntreeRequest;
import com.example.demo.dto.EntreeResponse;
import com.example.demo.dto.MetRequest;
import com.example.demo.dto.MetResponse;
import com.example.demo.dto.PlatRequest;
import com.example.demo.dto.PlatResponse;
import com.example.demo.models.Dessert;
import com.example.demo.models.Met;
import com.example.demo.services.DessertService;
import com.example.demo.services.EntreeService;
import com.example.demo.services.MetService;
import com.example.demo.services.PlatService;

@RestController
@RequestMapping("/api/desserts")

public class DessertController {

	private DessertService dessertService;

	@Autowired
	public DessertController(DessertService dessertService) {
		super();
		this.dessertService = dessertService;
	}

	// ADD A dessert
	@PostMapping
	public DessertResponse createEntree(@RequestBody DessertRequest request) {
		return dessertService.createDessert(request);
	}

	@GetMapping
	public List<Dessert> getAllDesserts() {
		return dessertService.getAllDesserts();
	}

	@GetMapping("/{name}")
	public DessertResponse getMet(@PathVariable("name") String name) {
		return dessertService.getDessertById(name);
	}

	@DeleteMapping("/{name}")
	public String deleteMetByID(@PathVariable("name") String name) {
		return dessertService.deleteDessertById(name);
	}

	@PutMapping("/{name}")
	public DessertResponse modifyMetByID(@PathVariable("name") String name, @RequestBody DessertRequest newMet) {
		return dessertService.modifyDessert(name, newMet);
	}

}
