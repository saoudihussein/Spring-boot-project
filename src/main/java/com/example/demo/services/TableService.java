package com.example.demo.services;

import java.util.List;

import com.example.demo.dto.ClientResponse;
import com.example.demo.dto.TableRequest;
import com.example.demo.dto.TableResponse;
import com.example.demo.models.Tablee;

public interface TableService {
	
	
	TableResponse createTable(TableRequest entity);
	List<Tablee> getAllTables();
	TableResponse getTableById(int id);
	String  deleteTableById(int id);
	String  deleteTables();
	TableResponse modifyTable(int id, TableRequest newTable);
	TableResponse plusReserve();
}
