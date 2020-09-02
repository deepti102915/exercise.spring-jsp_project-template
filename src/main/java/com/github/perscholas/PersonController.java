package com.github.perscholas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by leon on 9/2/2020.
 */
@RestController
@RequestMapping("/person-controller")
public class PersonController {

    private PersonServiceInterface service;

    @Autowired // Swap from `PersonServiceLogger` to `PersonService` to disable logging
    public PersonController(PersonServiceLogger service) {
        this.service = service;
    }

    @PostMapping(value = "/create")
    public ResponseEntity<Person> create(@RequestBody Person person) {
        return new ResponseEntity<>(service.create(person), HttpStatus.CREATED);
    }

    @GetMapping(value = "/read/{id}")
    public ResponseEntity<Person> read(@PathVariable Long id) {
        return new ResponseEntity<>(service.readById(id), HttpStatus.OK);
    }

    @GetMapping(value = "/read/all")
    public ResponseEntity<List<Person>> readAll() {
        return new ResponseEntity<>(service.readAll(), HttpStatus.OK);
    }

    @PutMapping(value = "/update/{id}")
    public ResponseEntity<Person> update(
            @PathVariable Long id,
            @RequestBody Person newData) {
        return new ResponseEntity<>(service.update(id, newData), HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<Person> delete(@PathVariable Long id) {
        return new ResponseEntity<>(service.deleteById(id), HttpStatus.OK);
    }

}
