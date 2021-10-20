package com.example.Addressbook.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import lombok.ToString;

public @ToString class AddressbookDTO {

	public int id;
	
	@Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s]{2,}$", message = "Addressbook name invalid")
	public String name;
	
	 @NotEmpty(message = "Address cannot be null")
	 @Pattern(regexp = "^[A-Z][a-zA-Z0-9\\s]+$", message = "Person Address Invalid")
	public String address;
	

	@NotEmpty(message = "PhoneNo cannot be null")
	@Pattern(regexp = "^[0-9]{10}$", message = "Person PhoneNo Invalid")
	public String phoneNo;
	
	
	public String email;
	
}
