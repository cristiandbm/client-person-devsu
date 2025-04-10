package com.devsu.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devsu.dto.Client;
import com.devsu.entities.ClientEntity;
import com.devsu.mapper.ClientMapper;
import com.devsu.repository.IClientRepository;
import com.devsu.service.IClientService;

@Service
public class ClientService implements IClientService {

	@Autowired
	private IClientRepository clientRepository;

	@Override
	public Client createClient(Client client) {
		ClientEntity clientSaved = clientRepository.save(ClientMapper.clientDtoToClientEntity(client));
		return ClientMapper.clientEntityToClientDto(clientSaved);

	}

	@Override
	public Client updateClient(String clientId, Client client) {
		Optional<ClientEntity> clientFound = clientRepository
				.findById(clientId);
		if (clientFound.isPresent()) {

			ClientEntity clientUpdated = clientFound.get();
			clientUpdated = ClientEntity.builder()
					.clientId(client.getClientId()).name(client.getName())
					.address(client.getAddress()).phone(client.getPhone())
					.password(client.getPassword()).status(client.isStatus())
					.build();
			clientRepository.save(clientUpdated);
			return ClientMapper.clientEntityToClientDto(clientUpdated);
		}
		return null;
	}

	@Override
	public boolean deleteClient(String clientId) {
		Optional<ClientEntity> clientFound = clientRepository
				.findById(clientId);
		if (clientFound.isPresent()) {
			clientRepository.delete(clientFound.get());
			return true;
		}
		return false;
	}

	@Override
	public Client findClient(String clientId) {
		Optional<ClientEntity> client = clientRepository.findById(clientId);
		if (client.isPresent()) {
			return ClientMapper.clientEntityToClientDto(client.get());
		}
		return null;
	}

}
