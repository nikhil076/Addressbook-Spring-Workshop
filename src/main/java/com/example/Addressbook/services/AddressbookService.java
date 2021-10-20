package com.example.Addressbook.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Addressbook.dto.AddressbookDTO;
import com.example.Addressbook.exceptions.AddressbookException;
import com.example.Addressbook.model.Addressbook;
import com.example.Addressbook.repository.AddressbookRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class AddressbookService implements IAddressbookService{

	@Autowired
	private AddressbookRepository addressbookRepository;
		
	@Override
	public List<Addressbook> getAddressbookData() {
		return addressbookRepository.findAll();
	}

	@Override
	public Addressbook getAddressbookDataById(int AddressId) {
		return addressbookRepository.findById(AddressId).orElseThrow( () -> new AddressbookException("Addressbook with addressbookId :" + AddressId + "does not exist"));
	}

	@Override
	public Addressbook createAddressBookData(AddressbookDTO addressbookDTO) {
		Addressbook addData = null;
		addData = new Addressbook(addressbookDTO);
		log.info("Addressbook data :"+addData.toString());
		return addressbookRepository.save(addData);
	}

	@Override
	public Addressbook updateAddressBookData(int AddressID, AddressbookDTO addressbookDTO) {	
		Addressbook addData = this.getAddressbookDataById(AddressID);
		addData.updateAddressbookData(addressbookDTO);
		return addressbookRepository.save(addData);
	}

	@Override
	public void deleteAddressbookData(int addressId) {
		Addressbook addData = this.getAddressbookDataById(addressId);
		addressbookRepository.delete(addData);
	}

}
