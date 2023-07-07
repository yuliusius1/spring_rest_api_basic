package com.belajarspring.models.repos;

import org.springframework.data.repository.CrudRepository;

import com.belajarspring.models.entities.Product;
import java.util.List;


public interface ProductRepo extends CrudRepository<Product, Long>{
    
    List<Product> findByNameContains(String name);

}
