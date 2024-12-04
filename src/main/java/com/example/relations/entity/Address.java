package com.example.relations.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Address {
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private int address_id;
     private String address_name;

     @ManyToOne(fetch = FetchType.LAZY)
     @JsonIgnore
     private Employee employee;
}
