/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.reto4.sa.reto4.service;

import com.reto4.sa.reto4.entity.Reservation;
import com.reto4.sa.reto4.repository.ReservationRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Gerox
 */

@Service
public class ReservationService {
	
	/**
	 * The repository.
	 */
    @Autowired
    private ReservationRepository repositorio;
    
    /**
     * Método save
     * 
     * @param reservation
     * @return
     */
    public Reservation saveReservation(Reservation reservation){
        return repositorio.save(reservation);
    }
    
    /**
     * Método findAll
     * 
     * @return
     */
    public List<Reservation> getReservationAll(){
        return repositorio.findAll();
    }
    
    /*
     * Método update
     */
    public Reservation updateReservation(Reservation reservation){
        Reservation existeReservation=repositorio.findById(reservation.getIdReservation()).orElse(null);
        existeReservation.setStartDate(reservation.getStartDate());
        existeReservation.setDevolutionDate(reservation.getDevolutionDate());
        return repositorio.save(existeReservation);
    }
    
    /**
     * Método delete
     * 
     * @param id
     */
    public void deleteReservation(int id){
        repositorio.deleteById(id);
    }
    
    /**
     * Método findById
     * 
     * @param reservation
     * @return
     */
    public Reservation getReservationById(Reservation reservation){
        return repositorio.findById(reservation.getIdReservation()).orElse(null);
    }
}
