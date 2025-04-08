package com.devsu.service;

import com.devsu.dto.Client;

public interface IClientService {
	
	Client createClient(Client client);
	
	Client updateClient(String clientId, Client client);
	
	boolean deleteClient(String clientId);
	
	Client findClient(String clientId);

}
