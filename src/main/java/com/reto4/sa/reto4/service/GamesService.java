/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.reto4.sa.reto4.service;

import com.reto4.sa.reto4.entity.Game;
import com.reto4.sa.reto4.repository.GamesRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Administrador
 */
@Service
public class GamesService {
    @Autowired
    private GamesRepository repositorio;
    
    // CRUD Create, Read, Update, Delete
    // Create
    public Game saveGame(Game juego){
        return repositorio.save(juego);
    }
    //Read
    public List<Game> getGamesAll(){
        return repositorio.findAll();
    }
    
    public Game getGameById(int id){
        return repositorio.findById(id).orElse(null);
    }
    
    
    //Update
    public Game updateGame(Game juego){
        Game existeJuego=repositorio.findById(juego.getId()).orElse(null);
        existeJuego.setName(juego.getName());
        existeJuego.setDeveloper(juego.getDeveloper());
        existeJuego.setYear(juego.getYear());
        existeJuego.setDescription(juego.getDescription());
        return repositorio.save(existeJuego);
    }
    //Delete
    public String deleteGame(int id){
        repositorio.deleteById(id);
        return "Registro con id "+id+" ha sido eliminado";
    }
}
