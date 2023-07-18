package com.contact.demo.entity;

import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Contact {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	private String firstname;
	
	private String lastname;
	
	@ElementCollection
	private List<Long> numbers;
	
	private String email;
	
	

	//Default constructor
	
	public Contact() {
		
	}
	
	
	
	//Parameterized constructor
	
	public Contact(int id, String firstname, String lastname, List<Long> numbers, String email) {
		
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.numbers = numbers;
		this.email = email;
	}
	
	//
	public Contact(String message) {
		
	}
	
	
	//Getters & Setters [POJO]
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getFirstname() {
		return firstname;
	}
	
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	
	public String getLastname() {
		return lastname;
	}
	
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
	public List<Long> getNumbers() {
		return numbers;
	}
	
	public void setNumbers(List<Long> numbers) {
		this.numbers = numbers;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
