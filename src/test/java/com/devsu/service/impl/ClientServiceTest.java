package com.devsu.service.impl;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.devsu.dto.Client;
import com.devsu.entities.ClientEntity;
import com.devsu.mapper.ClientMapper;
import com.devsu.repository.IClientRepository;

@ExtendWith(MockitoExtension.class)
public class ClientServiceTest {

	@Mock
	private IClientRepository repository;

	@InjectMocks
	private ClientService clientService;

	@Test
	void createClient_shouldCreateClient_whenIsSuccess() {

		ClientEntity clientEntity = ClientEntity.builder()
				.clientId("1")
				.name("Cris")
				.address("Calle falsa 123")
				.phone("12")
				.password("123")
				.status(true).build();

		when(repository.save(any())).thenReturn(clientEntity);

		Client client = ClientMapper.clientEntityToClientDto(clientEntity);
		Client clientSaved = clientService.createClient(client);
		assertNotNull(clientSaved);
		
	}
	
	@Test
	void deleteClient_shouldDeleteClient_whenIsDelete() {

		ClientEntity clientEntity = ClientEntity.builder()
				.clientId("1")
				.name("Cris")
				.address("Calle falsa 123")
				.phone("12")
				.password("123")
				.status(true).build();

		when(repository.findById(anyString())).thenReturn(Optional.of(clientEntity));
		doNothing().when(repository).delete(clientEntity);
		
		boolean isDelete = clientService.deleteClient(anyString());
		assertTrue(isDelete);

	}
	
	@Test
	void deleteClient_shouldDeleteClient_whenNotDelete() {

		when(repository.findById(anyString())).thenReturn(Optional.empty());	
		
		boolean isDelete = clientService.deleteClient(anyString());
		assertFalse(isDelete);

	}
}
