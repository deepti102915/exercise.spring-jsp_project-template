package com.github.perscholas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.util.Arrays;

/**
 * Created by leon on 9/9/2020.
 */
@Configuration
public class ProductConfig {
    @Autowired
    private ProductRepository repository;

    @PostConstruct
    public void setup() {
        repository.save(new Product());
        repository.save(new Product());
        repository.save(new Product());
        repository.save(new Product());
        repository.save(new Product());
    }
}
