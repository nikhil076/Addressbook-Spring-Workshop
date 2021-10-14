package com.example.Addressbook.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Addressbook.dto.AddressbookDTO;
import com.example.Addressbook.dto.ResponseDTO;
import com.example.Addressbook.model.Addressbook;
import com.example.Addressbook.services.IAddressbookService;

@RestController
@RequestMapping("/addressbook")
public class AddessbookController {

	@Autowired
	private IAddressbookService addressbookService;
	
	@RequestMapping(value = {"","/","/get"})
	public ResponseEntity<ResponseDTO> getAddressbookData(){
		List<Addressbook> addDataList = null;
		addDataList = addressbookService.getAddressbookData();
		ResponseDTO respDTO = new ResponseDTO("Get call successfull", addDataList);
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
	}
	
	@GetMapping("/get/{addressId}")
	public ResponseEntity<ResponseDTO> getAddressbookData(@PathVariable("addressId") int addressId){
		Addressbook addData = null;
		addData = addressbookService.getAddressbookDataById(addressId);
		ResponseDTO respDTO = new ResponseDTO("get call successfull for id", addData);
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
	}
	
	@PostMapping("/create")
	public ResponseEntity<ResponseDTO> createEmployeePayrollData(@RequestBody AddressbookDTO addressbookDTO){
		Addressbook addData = null;
		addData = addressbookService.createAAddressBookData(addressbookDTO);
		ResponseDTO respDTO = new ResponseDTO("Create Addressbook successfull", addData);
		return new ResponseEntity<ResponseDTO>(respDTO,HttpStatus.OK);
	}
	
	@PutMapping("/update/{empId}")
	public ResponseEntity<ResponseDTO> updateAddressbooksData(@PathVariable("addressId") int addressId, @RequestBody AddressbookDTO addressbookDTO){
		Addressbook addData = null;
		addData = addressbookService.updateAddressBookData(addressId, addressbookDTO);
		ResponseDTO respDTO = new ResponseDTO("update employee payroll data successfull", addData);
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{empid}")
	public ResponseEntity<ResponseDTO> deleteAddressbookData(@PathVariable("addressId") int addressId){
		addressbookService.deleteAddressbookData(addressId);
		ResponseDTO respDTO = new ResponseDTO("Delete Successfull", "Deleted id : "+addressId);
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
	}
}
