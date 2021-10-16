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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Gerox
 */

@RestController
@RequestMapping("/api/Client")
public class ClientsController {
    @Autowired
    private ClientsService servicio;
    
    @PostMapping("save")
    public ResponseEntity addClient(@RequestBody Client client){
        servicio.saveClient(client);
        return ResponseEntity.status(201).build();
    }
    @GetMapping("all")
    public List<Client> findAllClient(){
        return servicio.getClientAll();
    }
}
