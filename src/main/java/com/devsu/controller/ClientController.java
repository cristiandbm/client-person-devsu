package com.devsu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.devsu.dto.Client;
import com.devsu.service.IClientService;

@RestController
@RequestMapping("clientes")
public class ClientController {

	@Autowired
	private IClientService clientService;

	@PostMapping
	public ResponseEntity<Client> createClient(@RequestBody Client client) {
		return new ResponseEntity<Client>(clientService.createClient(client),
				HttpStatus.CREATED);
	}

	@GetMapping
	public ResponseEntity<Client> findClient(
			@RequestParam(name = "clientId", required = true) String clientId) {
		Client client = clientService.findClient(clientId);
		if (client == null) {
			return new ResponseEntity<Client>(client, HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<Client>(client, HttpStatus.OK);
	}

	@PatchMapping("/{clientId}")
	public ResponseEntity<Client> updateClient(
			@PathVariable(name = "clientId") String clientId,
			@RequestBody Client client) {
		Client clientFind = clientService.updateClient(clientId, client);
		if (clientFind == null) {
			return new ResponseEntity<Client>(clientFind,
					HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<Client>(clientFind, HttpStatus.OK);

	}

	@DeleteMapping("/{clientId}")
	public ResponseEntity<Boolean> deleteClient(
			@PathVariable(name = "clientId") String clientId) {
		return new ResponseEntity<Boolean>(clientService.deleteClient(clientId),
				HttpStatus.OK);
	}

}
