/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.reto4.sa.reto4.service;

import com.reto4.sa.reto4.entity.Category;
import com.reto4.sa.reto4.repository.CategoryRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Gerox
 */
@Service
public class CategoryService {
    @Autowired
    private CategoryRepository repositorio;
    
    // CRUD Create, Read, Update, Delete
    // Create
    public Category saveCategory(Category category){
        return repositorio.save(category);
    }
    //Read
    public List<Category> getCategoryAll(){
        return repositorio.findAll();
    }
    //Update
    public Category updateCategory(Category category){
        Category existeCategory=repositorio.findById(category.getId()).orElse(null);
        existeCategory.setName(category.getName());
        existeCategory.setDescription(category.getDescription());
        return repositorio.save(existeCategory);
    }
    //Delete
    public String deleteCategory(int id){
        repositorio.deleteById(id);
        return "Registro con id "+id+" ha sido eliminado";
    }
    
    //Filtro por ID
    public Category getCategoriaById(Category category){
        return repositorio.findById(category.getId()).orElse(null);
    }
}
