package com.belajarspring.models.repos;

import org.springframework.data.repository.CrudRepository;

import com.belajarspring.models.entities.Category;

public interface CategoryRepo extends CrudRepository<Category, Long>{
    
}
