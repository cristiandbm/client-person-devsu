package com.devsu.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devsu.entities.ClientEntity;

public interface IClientRepository extends JpaRepository<ClientEntity, String> {

}
