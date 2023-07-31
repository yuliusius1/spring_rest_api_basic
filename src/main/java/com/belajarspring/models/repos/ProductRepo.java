package com.belajarspring.models.repos;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.belajarspring.models.entities.Product;
import com.belajarspring.models.entities.Supplier;

import jakarta.websocket.server.PathParam;

import java.util.List;

public interface ProductRepo extends CrudRepository<Product, Long> {

    @Query("SELECT p FROM Product p WHERE p.name LIKE :name")
    public List<Product> findByNameContains(@PathParam("name") String name);

    @Query("SELECT p FROM Product p WHERE p.name = :name")
    public Product findByProductName(@PathParam("name") String name);

    @Query("SELECT p FROM Product p WHERE p.category.id = :categoryId")
    public List<Product> findProductByCategory(@PathParam("categoryId") Long categoryId);

    @Query("SELECT p FROM Product p WHERE :supplier MEMBER OF p.suppliers")
    public List<Product> findProductBySupplier(@PathParam("supplier") Supplier supplier);
}
