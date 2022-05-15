package com.gestionbuvette.uniregal.controllers;

import com.gestionbuvette.uniregal.models.Category;
import com.gestionbuvette.uniregal.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/categories")
    public String findAll(Model model){
        model.addAttribute("categories", categoryService.findAll());
        return "category";
    }
    @PostMapping(value="/categories/addNew")
    public String addNew(Category category){
        categoryService.save(category);
        return "redirect:/categories";
    }
    @RequestMapping("/categories/findById")
    @ResponseBody
    public Optional<Category> findById(int id)
    {
        return categoryService.findById(id);
    }

    @RequestMapping(value="/categories/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(Category category) {
        categoryService.save(category);
        return "redirect:/categories";
    }
    @RequestMapping(value="/categories/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(Integer id) {
        categoryService.delete(id);
        return "redirect:/categories";
    }
}
