package com.java.zenapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.zenapi.model.Client;
import com.java.zenapi.repository.ClientRepository;





@Service
public class ClientService {
	@Autowired
	private ClientRepository clientRepository;
	
	public List<Client> getAllClients(){
		return (List<Client>) clientRepository.findAll();
	}
	
	public List<Client> getAllClientsOrderByFirstName(){
		return clientRepository.findAllByOrderByFirstNameAsc();
	}
	
	public List<Client> searchClients(String search){
		
		return clientRepository.searchClients(search,search,search,search);
	}

	public void addClient(Client client) {
		clientRepository.save(client);
	}
	public Optional<Client> getClient(int clientId) {
		// TODO Auto-generated method stub
		return clientRepository.findById(clientId);
	}
	
	public void updateClient(Client client) {
		clientRepository.save(client);
	}
}
