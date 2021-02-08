package com.example.demo.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.models.Ticket;

public interface TicketRepository extends JpaRepository<Ticket, Integer> {
	 @Query(value = "SELECT sum(addition) from ticket WHERE date(datee)=?1", nativeQuery = true)
	  float RvParPeriode(String date);
	 
	 @Query(value = "SELECT sum(addition) as Somme, date(datee),Date_Format(datee,\"%D\")as SommeD,Date_Format(datee,\"%M\")as SommeM from ticket \r\n"
	 		+ "where client_id = ?1 \r\n"
	 		+ "GROUP BY Date_Format(datee,\"%M\"), Date_Format(datee,\"%D\")", nativeQuery = true)
	 List jourplusRes(int id);
	 
	 
	 @Query(value = "select date(datee) from ticket WHERE client_id=?1 GROUP by date(datee) LIMIT 1", nativeQuery = true)
		 List JourPLResParC(int id); 
	 

}
