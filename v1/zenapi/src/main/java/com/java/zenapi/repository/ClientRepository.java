package com.java.zenapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.java.zenapi.model.Client;

public interface ClientRepository extends CrudRepository<Client, Integer> {
	
	@Query("SELECT c FROM Client c where CONCAT(c.clientId, '') like %?1% or CONCAT(c.firstName, ' ', c.lastName) like %?2% or c.email like %?3% or c.phoneNumber like %?4%")
	List<Client> searchClients(String search,String search2,String search3,String search4);
	
	List<Client> findAllByOrderByFirstNameAsc();
}
