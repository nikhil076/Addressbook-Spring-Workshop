package com.example.Addressbook.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.example.Addressbook.dto.AddressbookDTO;

import lombok.Data;

@Entity
@Table(name = "Addressbook_database")
public @Data class Addressbook {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "addressbook_id")
	private int id;
	
	@Column(name = "name")
	private String name;
	private String address;
	private String phoneNo;
	private String email;
	

	public Addressbook() {
		super();
	}	
	
	public Addressbook(AddressbookDTO addressbookDTO) {
		this.updateAddressbookData(addressbookDTO);
	}

	public void updateAddressbookData(AddressbookDTO addressbookDTO) {
		this.name = addressbookDTO.name;
		this.address = addressbookDTO.address;
		this.phoneNo = addressbookDTO.phoneNo;
		this.email = addressbookDTO.email;
	}
}
