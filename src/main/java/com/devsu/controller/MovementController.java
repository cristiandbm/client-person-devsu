package com.devsu.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("movimientos")
public class MovementController {

	@PostMapping
	public ResponseEntity<String> createMovement() {
		return new ResponseEntity<String>("createMovement", HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<String> findMovement() {
		return new ResponseEntity<String>("findMovement", HttpStatus.OK);
	}

	@PatchMapping
	public ResponseEntity<String> updateMovement() {
		return new ResponseEntity<String>("updateMovement", HttpStatus.OK);
	}
}
