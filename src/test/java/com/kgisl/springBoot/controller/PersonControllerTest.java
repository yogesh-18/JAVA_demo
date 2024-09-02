package com.kgisl.springBoot.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.kgisl.springBoot.entity.Person;
import com.kgisl.springBoot.service.PersonService;

@ExtendWith(MockitoExtension.class)
public class PersonControllerTest {

    @Mock
    private PersonService personService;

    @InjectMocks
    private PersonController personController;

    public static List<Person> expected;

    Person person1 = new Person(1l, "Alice", "alice@example.com");
    Person person2 = new Person(2l, "Bob", "bob@example.com");

    @Test
    public void getallPersonsTest() {
        expected = Arrays.asList(person1, person2);
        // System.out.println(expected);
        when(personService.getAllPersons()).thenReturn(expected);
        ResponseEntity<List<Person>> actual = personController.getAllPersons();
        assertNotNull(actual);
        assertEquals(expected, actual.getBody());
        assertEquals(HttpStatus.OK, actual.getStatusCode());
    }

    @Test
    public void getPersonByIdTest() {
        Long id = 1l;
        when(personService.getPersonById(id)).thenReturn(person1);
        ResponseEntity<Person> actual = personController.getPersonById(id);
        assertNotNull(actual);
    }

    @Test
    public void updatePersonTest() {
        Person person = new Person(1l, "yogesh", "yogesh.gmail.com");
        Person updatedperson = new Person(1l, "Yogesh", "yogesh.email.com");
        Long id = 1l;
        when(personService.updatePerson(person)).thenReturn(updatedperson);
        ResponseEntity<Person> actual = personController.updatePerson(id, person);
        assertNotNull(actual);
        assertEquals(updatedperson, actual.getBody());
        assertEquals(HttpStatus.ACCEPTED, actual.getStatusCode());
    }

    @Test
    public void createPersonTest() {
        when(personService.createPerson(person1)).thenReturn(person1);
        ResponseEntity<Person> actual = personController.createPerson(person1);
        assertNotNull(actual);
        assertEquals(person1, actual.getBody());
        assertEquals(HttpStatus.ACCEPTED, actual.getStatusCode());
    }

    @Test
    public void deletePersonTest() {
        Long id = 1l;
        //when(personService.getPersonById(id)).thenReturn(person1);
        personController.deletePerson(id);
        verify(personService).deletePerson(id);
    }

}
