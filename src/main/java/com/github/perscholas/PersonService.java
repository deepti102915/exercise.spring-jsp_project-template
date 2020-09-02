package com.github.perscholas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by leon on 9/2/2020.
 */
@Service
public class PersonService implements PersonServiceInterface {

    private PersonRepository repository;

    @Autowired
    public PersonService(PersonRepository repository) {
        this.repository = repository;
    }

    @Override
    public Person create(Person person) {
        Person persistedPerson = repository.save(person);
        return persistedPerson;
    }

    @Override
    public Person readById(Long id) {
        Person personInDatabase = repository.findById(id).get();
        return personInDatabase;
    }

    @Override
    public List<Person> readAll() {
        Iterable<Person> iterablePerson = repository.findAll();
        List<Person> personList = new ArrayList<>();
        iterablePerson.forEach(personList::add);
        return personList;
    }

    @Override
    public Person update(Long idOfPersonToUpdate, Person newData) {
        Person personInDatabase = readById(idOfPersonToUpdate);
        personInDatabase.setFirstName(newData.getFirstName());
        personInDatabase.setLastName(newData.getLastName());
        personInDatabase.setBirthDate(newData.getBirthDate());
        personInDatabase = repository.save(personInDatabase);
        return personInDatabase;
    }

    @Override
    public Person deleteById(Long idOfPersonToDelete) {
        Person personToBeDeleted = readById(idOfPersonToDelete);
        repository.delete(personToBeDeleted);
        return personToBeDeleted;
    }
}
