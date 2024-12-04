package com.example.relations.dto;

import com.example.relations.entity.Address;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RequestDto {
    private String fname;
    private String lname;
    private List<Address> address;
    private List<String> departments;
    private int age;
    private String aadhaarNumber;
}
