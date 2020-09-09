package com.github.perscholas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by leon on 9/9/2020.
 */
@Service
public class ProductService {
    private ProductRepository repository;

    @Autowired
    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public Product create(Product productToBeCreated) {
        Product productInDatabase = repository.save(productToBeCreated);
        return productInDatabase;
    }

    public List<Product> readAll() {
        Iterable<Product> iterableProduct = repository.findAll();
        List<Product> productList = new ArrayList<>();
        iterableProduct.forEach(productList::add);
        return productList;
    }

    public Product readById(Long id) {
        return repository.findById(id).get();
    }


    public Product updateById(Long id, Product newData) {
        Product dataInDatabase = readById(id);
        dataInDatabase.setDescription(newData.getDescription());
        dataInDatabase.setName(newData.getName());
        return dataInDatabase;
    }

    public Product deleteById(Long id) {
        Product productToBeDeleted = readById(id);
        repository.delete(productToBeDeleted);
        return productToBeDeleted;
    }

}
