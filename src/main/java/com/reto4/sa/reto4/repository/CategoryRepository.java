/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.reto4.sa.reto4.repository;

import com.reto4.sa.reto4.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Gerox
 */
public interface CategoryRepository extends JpaRepository<Category,Integer> {
    
}
