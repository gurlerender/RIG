package com.rig.ReadingIsGoodApp.models;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonIgnore;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@Document
public class Customer {

    @Id
    @JsonIgnore
    private String id;
	private String name;
    private String surname;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;
    @Indexed(unique = true)
    private String email;
    private String address;
    private String phone;
    
	public Customer(String name, String surname, String password, String email, String address, String phone) {
		this.name = name;
		this.surname = surname;
		this.password = password;
		this.email = email;
		this.address = address;
		this.phone = phone;
	}
    
    
}
