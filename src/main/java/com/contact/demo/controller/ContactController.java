package com.contact.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.contact.demo.dao.ContactDao;
import com.contact.demo.entity.Contact;

@RestController
public class ContactController {

	@Autowired
	ContactDao contactDao;

	
	@PostMapping("/registerContact")
	public String registerContact(@RequestBody Contact contact) {
		contactDao.registerContact(contact);
		return "Contact Registered Successfully";
	}
	
	
	@GetMapping("/getAllContacts")
	public List<Contact> getAllContacts() {
		return contactDao.getAllContacts();
	}
	

	@GetMapping("/getContactById/{id}")
	public Contact getContactById(@PathVariable("id") int id) {
		
		Contact cotact = contactDao.getContactById(id);

		if (cotact != null){
			return cotact;
		}else{
			return new Contact("User Not Available!!!");
		}

	}
	
	
	
	
	
	

	
	@GetMapping("getContactsByNumber/{number}")
    public ResponseEntity<List<Contact>> searchContactsByNumber(@PathVariable Long number) {
        List<Contact> contacts = contactDao.findContactsByNumber(number);
        return ResponseEntity.ok(contacts);
    }
	
	
	
	
	
	
	@GetMapping("/getbyNmae/{firstname} {lastname}")
	public Contact findByNmae(@PathVariable("firstname") String firstname,@PathVariable("lastname") String lastname) {
		
		Contact cotact = contactDao.findByname(firstname, lastname);

		if (cotact != null){
			return cotact;
		}else{
			return new Contact("User Not Available!!!");
		}

	}
	

	@PutMapping("/updateContact")
	public String updateContact(@RequestBody Contact dept) {
		contactDao.updateContact(dept);
		return "Contact Updated Successfully";
	}
	
	
	@DeleteMapping("deleteContactByNumber/{id}/{numbers}")
	public String deleteNumberFromContact(
			@PathVariable int id,
			@PathVariable Long numbers) {
		contactDao.deleteNumberFromContact(id, numbers);
		return ("Number deleted successfully");
	}


	@DeleteMapping("/deleteContact/{deptId}")
	public String deleteContact(@PathVariable("deptId") int id) {
		contactDao.delete(id);
		return "Contact " + id + " Deleted Successfully!!!";
	}

}
