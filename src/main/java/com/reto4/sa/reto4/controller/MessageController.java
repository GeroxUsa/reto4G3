/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.reto4.sa.reto4.controller;


import com.reto4.sa.reto4.entity.Message;
import com.reto4.sa.reto4.service.MessageService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Gerox
 */

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
@RequestMapping("/api/Message/")
public class MessageController {
    @Autowired
    private MessageService servicio;

    @GetMapping("/all")
    public List<Message> findAllMessage() {
        return servicio.getMessageAll();
    }

    @PostMapping("/save")
    public ResponseEntity addMessage(@RequestBody Message message) {
        servicio.saveMessage(message);
        return ResponseEntity.status(201).build();
    }
    
    @PutMapping ("/update")
    public ResponseEntity updateMessage(@RequestBody Message message){
        servicio.updateMessage(message);
        return ResponseEntity.status(201).build();
    }
    
    @DeleteMapping ("/{id}")
    public ResponseEntity deleteMessage(@PathVariable int id){
        servicio.deleteMessage(id);
        return ResponseEntity.status(204).build();
    }
}
