package com.example.demo.services;

import java.util.List;

import com.example.demo.dto.MetRequest;
import com.example.demo.dto.MetResponse;
import com.example.demo.models.Met;


public interface MetService {

	MetResponse createMet(MetRequest entity);

	List<Met> getAllMets();

	MetResponse modifyMet(String name, MetRequest newMet);

	MetResponse getMetById(String name);

	String deleteMetById(String id);

	String deleteMets();
}
