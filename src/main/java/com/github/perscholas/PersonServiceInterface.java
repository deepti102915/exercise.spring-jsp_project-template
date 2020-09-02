package com.github.perscholas;

import java.util.List;

public interface PersonServiceInterface {
    Person create(Person person);

    Person readById(Long id);

    List<Person> readAll();

    Person update(Long idOfPersonToUpdate, Person newData);

    Person deleteById(Long idOfPersonToDelete);
}
