package com.kgisl.springBoot.repository;


import org.springframework.data.repository.ListCrudRepository;

import com.kgisl.springBoot.entity.*;

public interface PersonRepository extends ListCrudRepository<Person, Long> {
}
