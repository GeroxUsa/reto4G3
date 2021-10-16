/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.reto4.sa.reto4.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author Gerox
 */


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="reservation")
@JsonIgnoreProperties("messages")
public class Reservation {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int idReservation;
    private Date startDate;
    private Date devolutionDate;
    private String status = HttpStatus.CREATED.toString().substring(4).toLowerCase();
    
    @OneToMany
    @JsonIgnoreProperties("reservations")
    @JsonFormat(with = JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
    private List<Game> game;
    
    @OneToMany
    private List<Message> messages;
    
    @ManyToOne
    @JsonIgnoreProperties({"messages", "reservations"})
    @JsonFormat(with = JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
    private Client client;
    
    private String score;
    
}
