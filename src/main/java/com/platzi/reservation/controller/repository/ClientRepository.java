package com.platzi.reservation.controller.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.platzi.reservation.model.ClientDTO;

public interface ClientRepository extends JpaRepository<ClientDTO, String> {
	
	public List<ClientDTO> findByLastname(String lastname);
	public ClientDTO findByIdentification(String identification);
	
}
