package com.gestionbuvette.uniregal.services;


import com.gestionbuvette.uniregal.models.Category;
import com.gestionbuvette.uniregal.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    //Get All Categories
    public List<Category> findAll(){
        return categoryRepository.findAll();
    }
    //Save New Category
    public void save(Category category){
            categoryRepository.save(category);
    }
    //Get Category by id
    public Optional<Category> findById(int id) {
        return categoryRepository.findById(id);
    }
    //Delete Category
    public void delete(int id) {
        categoryRepository.deleteById(id);
    }
}

