package com.platzi.reservation.controller.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.platzi.reservation.controller.repository.ClientRepository;
import com.platzi.reservation.model.ClientDTO;

@Service
@Transactional(readOnly = true)
public class ClientService {

	private final ClientRepository clientRepository;

	public ClientService(ClientRepository clientRepository) {
		this.clientRepository = clientRepository;
	}

	@Transactional
	public ClientDTO create(ClientDTO client) {
		return this.clientRepository.save(client);
	}
	
	@Transactional
	public ClientDTO update(ClientDTO client) {
		return this.clientRepository.save(client);
	}
	
	@Transactional
	public void delete(ClientDTO client) {
		this.clientRepository.delete(client);
	}
	
	public ClientDTO findByIdentification(String identification) {
		return this.clientRepository.findByIdentification(identification);
	}
	
	public List<ClientDTO> findAll() {
		return this.clientRepository.findAll();
	}
	
}
