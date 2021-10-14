package com.example.Addressbook.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.example.Addressbook.dto.AddressbookDTO;

import lombok.Data;

public @Data class Addressbook {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	private String address;
	private String phoneNo;
	private String email;

	public Addressbook(int id, AddressbookDTO addressbookDTO) {

		this.id = id;
		this.name = addressbookDTO.name;
		this.address = addressbookDTO.address;
		this.phoneNo = addressbookDTO.phoneNo;
		this.email = addressbookDTO.email;
	}
	
}
