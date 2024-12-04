package com.example.relations.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Aadhaar {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(unique = true, nullable = false)
    private String aadhaarNumber;

    @OneToOne(mappedBy = "aadhaar", cascade = CascadeType.ALL)
    @JsonIgnore
    private Employee employee;
}
