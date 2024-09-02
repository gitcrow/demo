package com.example.demo.dao;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.Coffee;


/**
 * CoffeeRepository
 */
public interface CoffeeRepository extends CrudRepository<Coffee, String>{
    
}
