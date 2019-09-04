package com.platzi.reservation.view.resources;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.platzi.reservation.controller.service.ClientService;
import com.platzi.reservation.model.ClientDTO;
import com.platzi.reservation.view.resources.vo.ClientVO;

import ch.qos.logback.core.net.server.Client;

@RestController
@RequestMapping("/api/client")
public class ClientResource {

	private final ClientService clienteService;
	
	public ClientResource(ClientService clienteService) {
		this.clienteService = clienteService;
	}
	
	@PostMapping
	public ResponseEntity<Client> createClient(@RequestBody ClientVO clientvo) {
		ClientDTO client = new ClientDTO();
		client.setName(clientvo.getName());
		client.setLastname(clientvo.getLastname());
		client.setIdentification(clientvo.getIdentification());
		client.setAddress(clientvo.getAddress());
		client.setTelephone(clientvo.getTelephone());
		client.setEmail(clientvo.getEmail());
		return new ResponseEntity<>(this.clienteService.create(client), HttpStatus.CREATED);
	}
}
