package com.github.perscholas;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by leon on 9/9/2020.
 */
@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {
}
