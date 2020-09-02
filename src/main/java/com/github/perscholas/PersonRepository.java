package com.github.perscholas;

import org.springframework.data.repository.CrudRepository;

/**
 * Created by leon on 9/2/2020.
 */
public interface PersonRepository extends CrudRepository<Person, Long> {
}
