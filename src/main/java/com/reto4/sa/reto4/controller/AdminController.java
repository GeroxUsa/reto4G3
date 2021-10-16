/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.reto4.sa.reto4.controller;


import com.reto4.sa.reto4.entity.Admin;
import com.reto4.sa.reto4.service.AdminService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Gerox
 */

@RestController
@RequestMapping("/api/Admin/")
public class AdminController {
    @Autowired
    private AdminService servicio;

    @GetMapping("/all")
    public List<Admin> findAllAdmin() {
        return servicio.getAdminAll();
    }

    @PostMapping("/save")
    public ResponseEntity addAdmin(@RequestBody Admin admin) {
        servicio.saveAdmin(admin);
        return ResponseEntity.status(201).build();
    }
    
    @PutMapping("/update")
    public ResponseEntity updateAdmin(@RequestBody Admin admin){
        servicio.updateAdmin(admin);
        return ResponseEntity.status(201).build();
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity deleteAdmin(@PathVariable int id){
        servicio.deleteAdmin(id);
        return ResponseEntity.status(201).build();
    }
}
