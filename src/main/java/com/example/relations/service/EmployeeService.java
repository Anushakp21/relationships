package com.example.relations.service;

import com.example.relations.dto.RequestDto;
import com.example.relations.entity.Employee;

import java.util.List;

public interface EmployeeService {
RequestDto addEmployee(RequestDto requestDto);

    List<Employee> getAllEmployee();
}
