package com.contact.demo.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.contact.demo.entity.Contact;
import com.contact.demo.repository.ContactRepository;

@Repository
public class ContactDao {

	@Autowired
	ContactRepository contactRepository;

	
	//For Registering New Contact
	
	public Contact registerContact(Contact Contact) {
		return contactRepository.save(Contact);
	}	
	
	
	//For Getting all Contacts
	
	public List<Contact> getAllContacts() {
		return contactRepository.findAll();
	}

	
	//For Registering Contact by id
	
	public Contact getContactById(int deptId) {
		return contactRepository.findById(deptId).orElse(null);
	}
	
	public Contact findByname(String first,String last) {
		return contactRepository.findByName(first, last);
	}
	
	

	//For Updating Contact
	
	public Contact updateContact(Contact Contact) {
		return contactRepository.save(Contact);
	}
	
	 public List<Contact> findContactsByNumber(Long number) {
	        return contactRepository.findByNumbersContaining(number);
	    }
	//For to delete Contact from multiple numbers
	
	public void deleteNumberFromContact(int contactId, Long number) {
		
		Optional<Contact> optionalContact = contactRepository.findById(contactId);
		
		if (optionalContact.isPresent()) {
			Contact contact = optionalContact.get();
			contact.getNumbers().remove(number);
			contactRepository.save(contact);
		}

	}
	

	//For to delete all Contacts
	
	public void delete(int id) {
		contactRepository.deleteById(id);
	}
	
}
