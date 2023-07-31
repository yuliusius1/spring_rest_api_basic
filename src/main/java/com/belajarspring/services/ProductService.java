package com.belajarspring.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.belajarspring.models.entities.Product;
import com.belajarspring.models.entities.Supplier;
import com.belajarspring.models.repos.ProductRepo;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ProductService {

    @Autowired
    private ProductRepo productRepo;

    @Autowired
    private SupplierService supplierService;

    public Product save(Product product) {
        return productRepo.save(product);
    }

    public Product findOne(Long id) {
        Optional<Product> product = productRepo.findById(id);
        if (!product.isPresent()) {
            return null;
        }
        return product.get();
    }

    public Iterable<Product> findAll() {
        return productRepo.findAll();
    }

    public void removeOne(Long id) {
        productRepo.deleteById(id);
    }

    public void addSupplier(Supplier supplier, Long productId) {
        Product product = findOne(productId);
        if (product == null) {
            throw new RuntimeException("Product with id: " + productId + "Not found");
        }

        product.getSuppliers().add(supplier);
        save(product);
    }

    public List<Product> findByNameContains(String name) {
        return productRepo.findByNameContains("%" + name + "%");
    }

    public Product findByProductName(String name) {
        return productRepo.findByProductName(name);
    }

    public List<Product> findProductByCategory(Long categoryId) {
        return productRepo.findProductByCategory(categoryId);
    }

    public List<Product> findProductBySupplier(Long supplierId) {
        // Dicari dulu supplier dengan id yang diberikan
        Supplier supplier = supplierService.findOne(supplierId);
        if (supplier == null) {
            return new ArrayList<Product>();
        }
        return productRepo.findProductBySupplier(supplier);
    }
}
