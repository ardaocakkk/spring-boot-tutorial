package com.ocakarda.curddemo.rest;


import com.ocakarda.curddemo.dao.EmployeeRepository;
import com.ocakarda.curddemo.entity.Employee;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmployeeRest {
    private EmployeeRepository employeeRepository;

    public EmployeeRest(EmployeeRepository theEmployeeRepository) {
        this.employeeRepository = theEmployeeRepository;
    }

    @GetMapping("/employee")
    private List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }
}
