/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.reto4.sa.reto4.service;

import com.reto4.sa.reto4.entity.Departamento;
import com.reto4.sa.reto4.repository.DepartamentoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author DELL
 */
@Service
public class DepartamentoService {
      @Autowired
    private DepartamentoRepository repository;
    
    public Departamento saveDepartamento(Departamento departamento){
       return repository.save(departamento);
    }
    
    public List<Departamento> getDepartamentos(){
        return repository.findAll();
    }
    
    public Departamento getDepartamentoById(int id){
        return repository.findById(id).orElse(null);
    }
    
    //PUT
    public Departamento updateDepartamento(Departamento departamento){
        Departamento existeDepartamento=getDepartamentoById(departamento.getId_dep());
        existeDepartamento.setNomdep(departamento.getNomdep());
        existeDepartamento.setStartDate(departamento.getStartDate());
        existeDepartamento.setEndDate(departamento.getEndDate());
        return repository.save(departamento);
    }
    
    //DELETE
    public void deleteDepartamento(int id){
        repository.deleteById(id);
    }
    
    //Filtro por ID
    public Departamento getDepartamentoById(Departamento departamento){
        return repository.findById(departamento.getId_dep()).orElse(null);
    }
}
