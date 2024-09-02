package com.kgisl.springBoot.service;

import java.util.List;

import com.kgisl.springBoot.entity.Person;

public interface PersonService {
    List<Person> getAllPersons();
 
    Person createPerson(Person person);
 
    Person getPersonById(Long id);
 
    Person updatePerson(Person updatedPerson);
 
    void deletePerson(Long id);
} 