/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.reto4.sa.reto4.controller;



import com.reto4.sa.reto4.entity.Client;
import com.reto4.sa.reto4.service.ClientsService;
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
@CrossOrigin(origins = "*", methods={RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT, RequestMethod.DELETE})
@RequestMapping("/api/Client/")
public class ClientsController {
    @Autowired
    private ClientsService servicio;
    
    @GetMapping("/all")
    public List<Client> findAllClient(){
        return servicio.getClientAll();
    }
    
    @PostMapping("/save")
    public ResponseEntity addClient(@RequestBody Client client){
        servicio.saveClient(client);
        return ResponseEntity.status(201).build();
    }
    
    @PutMapping("/update")
    public ResponseEntity updateClient(@RequestBody Client client){
        servicio.updateClient(client);
        return ResponseEntity.status(201).build();
    }
    
    @DeleteMapping ("/{id}")
    public ResponseEntity deleteClient(@PathVariable int id){
        servicio.deleteClient(id);
        return ResponseEntity.status(204).build();
    }
    
}
