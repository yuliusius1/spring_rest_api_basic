package com.belajarspring.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.belajarspring.models.entities.Product;
import com.belajarspring.models.entities.Supplier;
import com.belajarspring.models.repos.SupplierRepo;

import jakarta.transaction.TransactionScoped;

@Service
@TransactionScoped
public class SupplierService {
    
    @Autowired
    private SupplierRepo supplierRepo;

    public Supplier save(Supplier supplier){
        return supplierRepo.save(supplier);
    }

    public Supplier findOne(Long id){
        Optional<Supplier> supplier = supplierRepo.findById(id);
        if(!supplier.isPresent()){
            return null;
        }
        return supplier.get();
    }

    public Iterable<Supplier> findAll(){
        return supplierRepo.findAll();
    }

    public void removeOne(Long id){
        supplierRepo.deleteById(id);
    }

    public void addProduct(Product product, Long supplierId){
        Supplier supplier = findOne(supplierId);
        if(supplier == null){
            throw new RuntimeException("Supplier with id: "+supplierId+"Not found");
        }
        supplier.getProducts().add(product);
        save(supplier);
    }
}
