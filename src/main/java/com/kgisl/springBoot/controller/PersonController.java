package com.kgisl.springBoot.controller;

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
import com.kgisl.springBoot.entity.Person;
import com.kgisl.springBoot.service.PersonService;


@RequestMapping("/person")
@RestController
public class PersonController {
    @Autowired
    PersonService personService;

	@GetMapping
	public ResponseEntity<List<Person>> getAllPersons(){
		List<Person> persons = personService.getAllPersons();
		return  new ResponseEntity<>(persons,HttpStatus.OK);
	}

	@PostMapping
	public void createPerson(@RequestBody Person person){
		personService.createPerson(person);
		
	}

	@GetMapping("/{id}")
	public ResponseEntity<Person> getPersonById(@PathVariable Long id){
		Person person = personService.getPersonById(id);
		return new ResponseEntity<>(person, person!=null ? HttpStatus.OK : HttpStatus.NOT_FOUND);
	}

	@PutMapping("/update/{id}")
    public ResponseEntity<Person> updatePerson(@PathVariable Long id, @RequestBody Person updatedPerson) {
        Person person =  personService.updatePerson(updatedPerson);
		return new ResponseEntity<>(person,HttpStatus.ACCEPTED);
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deletePerson(@PathVariable Long id){
		personService.deletePerson(id);
		return new ResponseEntity<>("Deleted successfully",HttpStatus.OK);
	}


	
}
