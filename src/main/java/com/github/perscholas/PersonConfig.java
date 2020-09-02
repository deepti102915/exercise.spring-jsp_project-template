package com.github.perscholas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.util.Date;

/**
 * Created by leon on 9/2/2020.
 */
@Configuration
public class PersonConfig {
    @Autowired
    private PersonRepository repository;

    @PostConstruct
    public void setup() {
        Person person1 = new Person();
        person1.setFirstName("Blah");
        person1.setLastName("Halb");
        person1.setBirthDate(new Date());

        Person person2 = new Person();
        person2.setFirstName("Second");
        person2.setLastName("person");
        person2.setBirthDate(new Date());

        repository.save(person1);
        repository.save(person2);
    }
}
