/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.reto4.sa.reto4.service;

import com.reto4.sa.reto4.entity.Message;
import com.reto4.sa.reto4.repository.MessageRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Gerox
 */

@Service
public class MessageService {
    @Autowired
    private MessageRepository repositorio;
    
    // CRUD Create, Read, Update, Delete
    // Create
    public Message saveMessage(Message message){
        return repositorio.save(message);
    }
    //Read
    public List<Message> getMessageAll(){
        return repositorio.findAll();
    }
    //Update
    public Message updateMessage(Message message){
        Message existeMessage=repositorio.findById(message.getId()).orElse(null);
        existeMessage.setMessageText(message.getMessageText());
//        existeMessage.s(message.getEmail());
//        existeMessage.setPassword(message.getPassword());
        return repositorio.save(existeMessage);
    }
    //Delete
    public String deleteMessage(int id){
        repositorio.deleteById(id);
        return "Registro con id "+id+" ha sido eliminado";
    }
    
    //Filtro por ID
    public Message getMessageById(Message message){
        return repositorio.findById(message.getId()).orElse(null);
    }
}
