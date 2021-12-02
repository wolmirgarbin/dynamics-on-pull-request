package com.example.demo.service;

import com.example.demo.model.Person;

import java.util.List;

public interface PersonService {

    Person save(Person person);

    List<Person> findAll();

}
