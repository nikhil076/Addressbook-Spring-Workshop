package com.example.Addressbook.services;

import java.util.List;

import com.example.Addressbook.dto.AddressbookDTO;
import com.example.Addressbook.model.Addressbook;

public interface IAddressbookService {

	List<Addressbook> getAddressbookData();
	Addressbook getAddressbookDataById(int AddressId);
	Addressbook createAAddressBookData(AddressbookDTO addressbookDTO);
	Addressbook updateAddressBookData(int AddressID,AddressbookDTO addressbookDTO);
	void deleteAddressbookData(int addressId);
}
