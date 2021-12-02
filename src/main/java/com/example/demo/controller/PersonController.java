package com.example.demo.controller;

import com.example.demo.model.Person;
import com.example.demo.service.PersonService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("person")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@AllArgsConstructor
public class PersonController {

    PersonService personService;

    @PostMapping
    public ResponseEntity<Person> save(@RequestBody Person person) {
        return ResponseEntity.status(HttpStatus.CREATED).body(personService.save(person));
    }

    @GetMapping
    public List<Person> findAll() {
        return personService.findAll();
    }
}
