package com.platzi.reservation.view.resources;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.platzi.reservation.controller.service.ClientService;
import com.platzi.reservation.model.ClientDTO;
import com.platzi.reservation.view.resources.vo.ClientVO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;


@RestController
@RequestMapping("/api/client")
@Api(tags = "client")
public class ClientResource {

	private final ClientService clientService;
	
	public ClientResource(ClientService clientService) {
		this.clientService = clientService;
	}
	
	@PostMapping
	@ApiOperation(value = "Create client", notes = "Service to create a new client")
	@ApiResponses(value = {@ApiResponse(code = 201, message = "Client succesfully created"),
		@ApiResponse(code = 400, message = "Invalid request")})
	public ResponseEntity<ClientDTO> createClient(@RequestBody ClientVO clientvo) {
		ClientDTO client = new ClientDTO();
		client.setName(clientvo.getName());
		client.setLastname(clientvo.getLastname());
		client.setIdentification(clientvo.getIdentification());
		client.setAddress(clientvo.getAddress());
		client.setTelephone(clientvo.getTelephone());
		client.setEmail(clientvo.getEmail());
		return new ResponseEntity<>(this.clientService.create(client), HttpStatus.CREATED);
	}
	
	@PutMapping("/{identification}")
	@ApiOperation(value = "Update client", notes = "Service to update a new client")
	@ApiResponses(value = {@ApiResponse(code = 201, message = "Client succesfully updated"),
		@ApiResponse(code = 404, message = "Client not found")})
	public ResponseEntity<ClientDTO> updateClient(@PathVariable("identification") String identification, ClientVO clientvo) {
		ClientDTO client = this.clientService.findByIdentification(identification);
		if(client == null) {
			return new ResponseEntity<ClientDTO>(HttpStatus.NOT_FOUND);
		} else {
			client.setName(clientvo.getName());
			client.setLastname(clientvo.getLastname());
			client.setIdentification(clientvo.getIdentification());
			client.setAddress(clientvo.getAddress());
			client.setTelephone(clientvo.getTelephone());
			client.setEmail(clientvo.getEmail());
		}
		return new ResponseEntity<>(this.clientService.update(client), HttpStatus.OK);
	}
	
	@DeleteMapping("/{identification}")
	@ApiOperation(value = "Delete client", notes = "Service to delete a client")
	@ApiResponses(value = {@ApiResponse(code = 201, message = "Client succesfully deleted"),
		@ApiResponse(code = 404, message = "Client not found")})
	public void removeClient(@PathVariable("identification") String identification) {
		ClientDTO client = this.clientService.findByIdentification(identification);
		if(client != null) {
			this.clientService.delete(client);
		}
	}
	
	@GetMapping
	@ApiOperation(value = "List clients", notes = "Service to list all clients")
	@ApiResponses(value = {@ApiResponse(code = 201, message = "Clients found"),
		@ApiResponse(code = 404, message = "Clients not found")})
	public ResponseEntity<List<ClientDTO>> findAll() {
		return ResponseEntity.ok(this.clientService.findAll());
	}
}
