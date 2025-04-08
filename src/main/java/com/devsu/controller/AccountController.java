package com.devsu.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("cuentas")
public class AccountController {

	@PostMapping
	public ResponseEntity<String> createAccount() {
		return new ResponseEntity<String>("createAccount", HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<String> findAccount() {
		return new ResponseEntity<String>("findAccount", HttpStatus.OK);
	}

	@PatchMapping
	public ResponseEntity<String> updateAccount() {
		return new ResponseEntity<String>("updateAccount", HttpStatus.OK);
	}

}
