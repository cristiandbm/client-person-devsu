package com.devsu.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class Person {
	
	private Long id;
	
	private String name;
	
	private String gender;
	
	private Integer age;
	
	private String address;
	
	private String phone;
	

}
