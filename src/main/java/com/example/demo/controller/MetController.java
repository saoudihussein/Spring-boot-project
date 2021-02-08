package com.example.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.MetRequest;
import com.example.demo.dto.MetResponse;
import com.example.demo.models.Met;
import com.example.demo.services.MetService;

@RestController
@RequestMapping("/api/mets")

public class MetController {

	private MetService service;

	@Autowired
	public MetController(MetService service) {
		super();
		this.service = service;
	}

	// ADD A Met
	@PostMapping
	public MetResponse createMet(@Valid @RequestBody MetRequest request) {
		return service.createMet(request);
	}

	// DISPLAY METS
	@GetMapping
	public List<Met> getAllMets() {
		return service.getAllMets();
	}

	@GetMapping("/{name}")
	public MetResponse getMet(@PathVariable("name") String name) {
		return service.getMetById(name);
	}

	@DeleteMapping("/{name}")
	public String deleteMetByID(@PathVariable("name") String name) {
		return service.deleteMetById(name);
	}

	@PutMapping("/{name}")
	public MetResponse modifyMetByID(@PathVariable("name") String name,@Valid @RequestBody MetRequest newMet) {
		return service.modifyMet(name, newMet);
	}

}
