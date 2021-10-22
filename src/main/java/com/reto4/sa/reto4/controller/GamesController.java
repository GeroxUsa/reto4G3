/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.reto4.sa.reto4.controller;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.reto4.sa.reto4.entity.Game;
import com.reto4.sa.reto4.service.GamesService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Administrador
 */
@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
@RequestMapping("/api/Game/")
public class GamesController {

    @Autowired
    private GamesService servicio;

    @PostMapping("/save")
    public ResponseEntity addGame(@RequestBody Game juego) {
        servicio.saveGame(juego);
        return ResponseEntity.status(201).build();
    }

    @GetMapping("/all")
    public List<Game> findAllGames() {
        return servicio.getGamesAll();
    }
    //Not used
//    @GetMapping("/products/{id}")
//    public Game findGameId(@PathVariable int id) {
//        return servicio.getGameById(id);
//    }

    @PutMapping("/update")
    public ResponseEntity updateGame(@RequestBody Game game) {
        servicio.updateGame(game);
        return ResponseEntity.status(201).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteGame(@PathVariable int id) {
        servicio.deleteGame(id);
        return ResponseEntity.status(204).build();
    }

}
