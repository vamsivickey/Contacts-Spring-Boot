package com.contact.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.contact.demo.entity.Contact;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Integer> {
	
	@Query("from Contact  where firstname = :firstname AND lastname = :lastname ")
	Contact findByName(@Param("firstname") String firstname,@Param("lastname") String lastname);

	
	 List<Contact> findByNumbersContaining(Long number);
	
}
