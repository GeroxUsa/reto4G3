/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.reto4.sa.reto4.service;

import com.reto4.sa.reto4.entity.Score;
import com.reto4.sa.reto4.repository.ScoreRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Gerox
 */

@Service
public class ScoreService {
    @Autowired
    private ScoreRepository repositorio;
    
    // CRUD Create, Read, Update, Delete
    // Create
    public Score saveScore(Score score){
        return repositorio.save(score);
    }
    //Read
    public List<Score> getScoreAll(){
        return repositorio.findAll();
    }
    //Update
    public Score updateScore(Score score){
        Score existeScore=repositorio.findById(score.getId()).orElse(null);
        existeScore.setScore(score.getScore());
//        existeMessage.s(message.getEmail());
//        existeMessage.setPassword(message.getPassword());
        return repositorio.save(existeScore);
    }
    //Delete
    public String deleteScore(int id){
        repositorio.deleteById(id);
        return "Registro con id "+id+" ha sido eliminado";
    }
    
    //Filtro por ID
    public Score getScoreById(Score score){
        return repositorio.findById(score.getId()).orElse(null);
    }
}
