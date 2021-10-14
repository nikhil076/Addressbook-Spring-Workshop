package com.example.Addressbook.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.Addressbook.dto.AddressbookDTO;
import com.example.Addressbook.model.Addressbook;

@Service
public class AddressbookService implements IAddressbookService{

	private List<Addressbook> addressbookList = new ArrayList<>();
	
	@Override
	public List<Addressbook> getAddressbookData() {
		return addressbookList;
	}

	@Override
	public Addressbook getAddressbookDataById(int AddressId) {
		return addressbookList.get(AddressId-1);
	}

	@Override
	public Addressbook createAAddressBookData(AddressbookDTO addressbookDTO) {
		Addressbook addData = null;
		addData = new Addressbook(addressbookList.size()+1, addressbookDTO);
		addressbookList.add(addData);
		return addData;
	}

	@Override
	public Addressbook updateAddressBookData(int AddressID, AddressbookDTO addressbookDTO) {	
		Addressbook addData = this.getAddressbookDataById(AddressID);
		addData.setName(addressbookDTO.name);
		addData.setAddress(addressbookDTO.address);
		addData.setPhoneNo(addressbookDTO.phoneNo);
		addData.setEmail(addressbookDTO.email);
		addressbookList.set(AddressID-1, addData);
		return addData;
	}

	@Override
	public void deleteAddressbookData(int addressId) {
		addressbookList.remove(addressId-1);
	}

}
