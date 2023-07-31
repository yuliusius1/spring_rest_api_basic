package com.belajarspring.models.repos;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.belajarspring.models.entities.Product;

import jakarta.websocket.server.PathParam;

import java.util.List;

public interface ProductRepo extends CrudRepository<Product, Long> {

    @Query("SELECT p FROM Product p WHERE p.name LIKE :name")
    public List<Product> findByNameContains(@PathParam("name") String name);

    @Query("SELECT p FROM Product p WHERE p.name = :name")
    public Product findByProductName(@PathParam("name") String name);

    @Query("SELECT p FROM Product p WHERE p.category.id = :categoryId")
    public List<Product> findProductByCategory(@PathParam("categoryId") Long categoryId);
}
