/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.reto4.sa.reto4.controller;


import com.reto4.sa.reto4.entity.Score;
import com.reto4.sa.reto4.service.ScoreService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Gerox
 */

@RestController
@RequestMapping("/api/Score/")
public class ScoreController {
    @Autowired
    private ScoreService servicio;

    @GetMapping("/all")
    public List<Score> findAllScore() {
        return servicio.getScoreAll();
    }
}
