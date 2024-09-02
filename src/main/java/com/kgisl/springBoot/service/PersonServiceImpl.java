package com.kgisl.springBoot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kgisl.springBoot.entity.Person;
import com.kgisl.springBoot.repository.PersonRepository;

@Service
public class PersonServiceImpl implements PersonService{

    @Autowired
    private PersonRepository personRepository;


    @Override
    public List<Person> getAllPersons() {
        return personRepository.findAll();
    }

    @Override
    public Person createPerson(Person person) {
        return personRepository.save(person);
    }

    @Override
    public Person getPersonById(Long id) {
        return personRepository.findById(id).orElse(null);
    }

    @Override
    public Person updatePerson(Person updatedPerson) {
        //Person person = personRepository.findById(id).orElse(null);
            // person.setFirstName(updatedPerson.getFirstName());
            // person.setLastName(updatedPerson.getLastName());
            // person.setEmail(updatedPerson.getEmail());
            return personRepository.save(updatedPerson);
    }

    @Override
    public void deletePerson(Long id) {
         personRepository.deleteById(id);
    }
    
}
