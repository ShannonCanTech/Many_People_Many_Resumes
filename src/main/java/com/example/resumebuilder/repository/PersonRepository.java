package com.example.resumebuilder.repository;

import com.example.resumebuilder.Person;
import org.springframework.data.repository.CrudRepository;

public interface PersonRepository extends CrudRepository<Person, Long>{
}
