package com.github.perscholas;



import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by leon on 9/2/2020.
 */
public interface DefaultPersonServiceInterface extends PersonServiceInterface {

    default Logger getLogger() {
        return Logger.getLogger(getClass().getName());
    }
    default void info(String message, Object... args) {
        getLogger().log(Level.INFO, String.format(message, args));
    }
    
    CrudRepository<Person, Long> getRepository();

    @Override
    default Person create(Person person) {
        info( "Attempting to create the following person\n\t %s", person.toString());
        Person persistedPerson = getRepository().save(person);
        info( "Successfully created the following person\n\t %s", person.toString());
        return persistedPerson;
    }

    @Override
    default Person readById(Long id) {
        info("Attempting to find person with id [ %s ]", id);
        Person personInDatabase = getRepository().findById(id).get();
        info("Successfully found person with id [ %s ]\n\t %s", id, personInDatabase.toString());
        return personInDatabase;
    }

    @Override
    default List<Person> readAll() {
        info("Attempting to retrieve all persons from database");
        Iterable<Person> iterablePerson = getRepository().findAll();
        info("Successfully retrieved all persons from database");
        List<Person> personList = new ArrayList<>();
        iterablePerson.forEach(personList::add);
        return personList;
    }

    @Override
    default Person update(Long idOfPersonToUpdate, Person newData) {
        Person personInDatabase = readById(idOfPersonToUpdate);
        info("Attempting to update person with id [ %s ] from\n\t %s \nto\n\t %s",
                idOfPersonToUpdate,
                personInDatabase,
                newData);
        personInDatabase.setFirstName(newData.getFirstName());
        personInDatabase.setLastName(newData.getLastName());
        personInDatabase.setBirthDate(newData.getBirthDate());
        personInDatabase = getRepository().save(personInDatabase);
        info("Successfully updated person with id [ %s ] from\n\t %s \nto\n\t %s",
                idOfPersonToUpdate,
                personInDatabase,
                newData);
        return personInDatabase;
    }

    @Override
    default Person deleteById(Long idOfPersonToDelete) {
        Person personToBeDeleted = readById(idOfPersonToDelete);
        getRepository().delete(personToBeDeleted);
        return personToBeDeleted;
    }
}
