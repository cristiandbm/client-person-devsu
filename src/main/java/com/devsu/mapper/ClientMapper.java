package com.devsu.mapper;

import com.devsu.dto.Client;
import com.devsu.entities.ClientEntity;

public class ClientMapper {
	
	public static ClientEntity clientDtoToClientEntity(Client client) {
		return ClientEntity.builder()
				.clientId(client.getClientId())
				.name(client.getName())
				.address(client.getAddress())
				.phone(client.getPhone())
				.password(client.getPassword())
				.status(client.isStatus())
				.build();
	}
	
	public static Client clientEntityToClientDto(ClientEntity client) {
		return Client.builder()				
				.clientId(client.getClientId())
				.name(client.getName())
				.address(client.getAddress())
				.phone(client.getPhone())
				.password(client.getPassword())
				.status(client.isStatus())
				.build();
	}

}
