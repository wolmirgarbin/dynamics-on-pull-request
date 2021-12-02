package com.example.demo.data;

import com.example.demo.model.Person;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PersonRepositoryTest {

    @Autowired
    private PersonRepository personRepository;

    @Test
    public void testSaveAndCount() {
        Person person = new Person();
        person.setName("Test");
        person.setLastName("Persistence");
        person.setYears(71);

        personRepository.save(person);

        Assertions.assertEquals(1L, personRepository.count());
    }

    @Test
    public void testSaveAndValidNames() {
        Person person = new Person();
        person.setName("Test");
        person.setLastName("Persistence");
        person.setYears(71);

        personRepository.save(person);

        var list = personRepository.findAll();

        Assertions.assertEquals(1, list.size());
        Assertions.assertEquals("Test", list.get(0).getName());
        Assertions.assertEquals("Persistence", list.get(0).getLastName());
        Assertions.assertEquals(71, list.get(0).getYears());
    }
}
