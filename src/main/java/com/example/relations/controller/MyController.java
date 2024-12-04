package com.example.relations.controller;

import com.example.relations.dto.RequestDto;
import com.example.relations.entity.Employee;
import com.example.relations.repository.EmployeeRepo;
import com.example.relations.service.EmployeeServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MyController {

    @Autowired
    EmployeeServiceImpl employeeService;

    @PostMapping("/insert")
    public RequestDto addEmployee(@RequestBody RequestDto requestDto)
    {
       return employeeService.addEmployee(requestDto);
    }
    @GetMapping("/csrf-token")
    public CsrfToken getToken(HttpServletRequest request)
    {
        return (CsrfToken) request.getAttribute("_csrf");
    }

    @GetMapping("/get")
    public List<Employee> getAllEmployee()
    {
        return employeeService.getAllEmployee();
    }
}
