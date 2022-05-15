package com.gestionbuvette.uniregal.services;

import com.gestionbuvette.uniregal.models.Product;
import com.gestionbuvette.uniregal.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    //Get All Products
    public List<Product> findAll(){
        return productRepository.findAll();
    }
    //Save New Product
    public void save(Product product){
        productRepository.save(product);
    }
    //Get Product by id
    public Optional<Product> findById(int id) {
        return productRepository.findById(id);
    }
    //Delete Product
    public void delete(int id) {
        productRepository.deleteById(id);
    }
}
