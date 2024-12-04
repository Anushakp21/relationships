package com.example.relations.entity;

import com.example.relations.dto.RequestDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long employee_id;
    private String fname;
    private String lname;
    private int age;
    private LocalDate doj;

    @ElementCollection
    @CollectionTable(name="departments_data",joinColumns = @JoinColumn(name="emp_id"))
    private List<String> departments;

    @OneToMany(mappedBy = "employee",cascade = CascadeType.ALL)
    private  List<Address> address;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "aadhaar_id", referencedColumnName = "id")
    private Aadhaar aadhaar;


    public Employee(RequestDto requestDto) {
        this.fname=requestDto.getFname();
        this.lname=requestDto.getLname();
        this.age = requestDto.getAge();
        this.doj = LocalDate.now();
        this.departments =requestDto.getDepartments();
        this.address=requestDto.getAddress();
    }
}
