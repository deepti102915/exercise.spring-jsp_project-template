package com.github.perscholas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by leon on 9/2/2020.
 */
@Service
public class PersonServiceLogger implements PersonServiceInterface{
    private PersonServiceInterface serviceToBeLogged;

    @Autowired
    public PersonServiceLogger(PersonService serviceToBeLogged) {
        this.serviceToBeLogged = serviceToBeLogged;
    }

    private Logger getLogger() {
        return Logger.getLogger(getClass().getName());
    }
    private void info(String message, Object... args) {
        getLogger().log(Level.INFO, String.format(message, args));
    }


    @Override
    public Person create(Person person) {
        info( "Attempting to create the following person\n\t %s", person.toString());
        Person persistedPerson = serviceToBeLogged.create(person);
        info( "Successfully created the following person\n\t %s", person.toString());
        return persistedPerson;
    }

    @Override
    public Person readById(Long id) {
        info("Attempting to find person with id [ %s ]", id);
        Person personInDatabase = serviceToBeLogged.readById(id);
        info("Successfully found person with id [ %s ]\n\t %s", id, personInDatabase.toString());
        return personInDatabase;
    }

    @Override
    public List<Person> readAll() {
        info("Attempting to retrieve all persons from database");
        Iterable<Person> iterablePerson = serviceToBeLogged.readAll();
        info("Successfully retrieved all persons from database");
        List<Person> personList = new ArrayList<>();
        iterablePerson.forEach(personList::add);
        return personList;
    }

    @Override
    public Person update(Long idOfPersonToUpdate, Person newData) {
        Person personInDatabase = serviceToBeLogged.readById(idOfPersonToUpdate);
        info("Attempting to update person with id [ %s ] from\n\t %s \nto\n\t %s",
                idOfPersonToUpdate,
                personInDatabase,
                newData);
        personInDatabase = serviceToBeLogged.update(idOfPersonToUpdate, newData);
        info("Successfully updated person with id [ %s ] from\n\t %s \nto\n\t %s",
                idOfPersonToUpdate,
                personInDatabase,
                newData);
        return personInDatabase;
    }

    @Override
    public Person deleteById(Long idOfPersonToDelete) {
        info("Deleting person with id [ %s ]", idOfPersonToDelete);
        Person personToBeDeleted = serviceToBeLogged.deleteById(idOfPersonToDelete);
        info("Successfully deleted person with id [ %s ]", idOfPersonToDelete);
        return personToBeDeleted;
    }
}
