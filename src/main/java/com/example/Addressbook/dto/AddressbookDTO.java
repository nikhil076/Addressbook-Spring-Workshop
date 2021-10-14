package com.example.Addressbook.dto;

public class AddressbookDTO {

	public int id;
	public String name;
	public String address;
	public String phoneNo;
	public String email;
	
	public AddressbookDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AddressbookDTO(int id, String name, String address, String phoneNo, String email) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.phoneNo = phoneNo;
		this.email = email;
	}

	@Override
	public String toString() {
		return "AddressbookDTO [id=" + id + ", name=" + name + ", address=" + address + ", phoneNo=" + phoneNo
				+ ", email=" + email + "]";
	}
}
