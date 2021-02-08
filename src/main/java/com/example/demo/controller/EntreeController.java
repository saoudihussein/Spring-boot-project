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

import com.example.demo.dto.EntreeRequest;
import com.example.demo.dto.EntreeResponse;
import com.example.demo.dto.MetRequest;
import com.example.demo.dto.MetResponse;
import com.example.demo.dto.PlatRequest;
import com.example.demo.dto.PlatResponse;
import com.example.demo.models.Entree;
import com.example.demo.models.Met;
import com.example.demo.models.Plat;
import com.example.demo.services.EntreeService;
import com.example.demo.services.MetService;
import com.example.demo.services.PlatService;

@RestController
@RequestMapping("/api/entrees")

public class EntreeController {

	private EntreeService entreeService;

	@Autowired
	public EntreeController(EntreeService entreeService) {
		super();
		this.entreeService = entreeService;
	}

	// ADD A Entree
	@PostMapping
	public EntreeResponse createEntree(@RequestBody EntreeRequest request) {
		return entreeService.createEntree(request);
	}

	@GetMapping
	public List<Entree> getAllEntree() {
		return entreeService.getAllEntrees();
	}

	@GetMapping("/{name}")
	public EntreeResponse getPlat(@PathVariable("name") String name) {
		return entreeService.getEntreeById(name);
	}

	@DeleteMapping("/{name}")
	public String deletePlatByID(@PathVariable("name") String name) {
		return entreeService.deleteEntreeById(name);
	}

	@PutMapping("/{name}")
	public EntreeResponse modifyPlatByID(@PathVariable("name") String name, @RequestBody EntreeRequest newPlat) {
		return entreeService.modifyEntree(name, newPlat);
	}

}
