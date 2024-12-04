package com.example.relations.service;

import com.example.relations.dto.RequestDto;
import com.example.relations.entity.Aadhaar;
import com.example.relations.entity.Address;
import com.example.relations.entity.Employee;
import com.example.relations.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    EmployeeRepo employeeRepo;
    @Override
    public RequestDto addEmployee(RequestDto requestDto) {
        Employee employee=new Employee(requestDto);
        //setting aadhaar number
        Aadhaar aadhaar = new Aadhaar();
        aadhaar.setAadhaarNumber(requestDto.getAadhaarNumber());
        aadhaar.setEmployee(employee);
        employee.setAadhaar(aadhaar);
        List<Address> addresses=requestDto.getAddress();
        addresses.forEach(address -> address.setEmployee(employee));
        employee.setAddress(addresses);
        return mapToDTO(employeeRepo.save(employee));
    }

    @Override
    public List<Employee> getAllEmployee() {
     return  employeeRepo.findAll();
    }

    private RequestDto mapToDTO(Employee employee) {
        RequestDto requestDto = new RequestDto();
        requestDto.setFname(employee.getFname());
        requestDto.setLname(employee.getLname());
        requestDto.setAge(employee.getAge());
        requestDto.setDepartments(employee.getDepartments());
        requestDto.setAddress(employee.getAddress());
        requestDto.setAadhaarNumber(employee.getAadhaar().getAadhaarNumber());
        return requestDto;
    }
}
