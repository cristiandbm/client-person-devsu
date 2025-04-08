package com.devsu.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "accounts")
@Getter
@Setter
public class AccountEntity {

	@Id
	@Column
	private long number;
	
	private String type;
	
	@Column(name = "opening_balance")
	private Double openingBalance;
	
	private boolean status;
	
	@ManyToOne
	@JoinColumn(name = "client_id")
	private ClientEntity clientId;
	
}
