/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.reto4.sa.reto4.service;

import com.reto4.sa.reto4.entity.Client;
import com.reto4.sa.reto4.repository.ClientsRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Gerox
 */
@Service
public class ClientsService {
    @Autowired
    private ClientsRepository repositorio;
    
    // CRUD Create, Read, Update, Delete
    // Create
    public Client saveClient(Client client){
        return repositorio.save(client);
    }
    //Read
    public List<Client> getClientAll(){
        return repositorio.findAll();
    }
    //Update
    public Client updateClient(Client client){
        Client existeCliente=repositorio.findById(client.getIdClient()).orElse(null);
        existeCliente.setName(client.getName());
        existeCliente.setEmail(client.getEmail());
        existeCliente.setAge(client.getAge());
        return repositorio.save(existeCliente);
    }
    //Delete
    public String deleteClient(int id){
        repositorio.deleteById(id);
        return "Registro con id "+id+" ha sido eliinado";
    }
}
