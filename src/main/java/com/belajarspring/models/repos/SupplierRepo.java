package com.belajarspring.models.repos;

import org.springframework.data.repository.CrudRepository;

import com.belajarspring.models.entities.Supplier;

public interface SupplierRepo extends CrudRepository<Supplier, Long> {
    
}
