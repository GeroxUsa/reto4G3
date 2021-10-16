/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.reto4.sa.reto4.service;


import com.reto4.sa.reto4.entity.Admin;
import com.reto4.sa.reto4.repository.AdminRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Gerox
 */
@Service
public class AdminService {
    @Autowired
    private AdminRepository repositorio;
    
    // CRUD Create, Read, Update, Delete
    // Create
    public Admin saveAdmin(Admin admin){
        return repositorio.save(admin);
    }
    //Read
    public List<Admin> getAdminAll(){
        return repositorio.findAll();
    }
    //Update
    public Admin updateAdmin(Admin admin){
        Admin existeAdmin=repositorio.findById(admin.getId()).orElse(null);
        existeAdmin.setName(admin.getName());
        existeAdmin.setEmail(admin.getEmail());
        existeAdmin.setPassword(admin.getPassword());
        return repositorio.save(existeAdmin);
    }
    //Delete
    public void deleteAdmin(int id){
        repositorio.deleteById(id);
    }
    
    //Filtro por ID
    public Admin getAdminById(Admin admin){
        return repositorio.findById(admin.getId()).orElse(null);
    }
}
