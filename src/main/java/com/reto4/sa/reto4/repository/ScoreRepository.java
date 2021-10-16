/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.reto4.sa.reto4.repository;

import com.reto4.sa.reto4.entity.Score;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Gerox
 */
public interface ScoreRepository extends JpaRepository<Score,Integer>{
    
}
