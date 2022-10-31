package com.revature.projects.controllers;


import com.revature.projects.models.Employee;
import com.revature.projects.repositories.EmployeeRepository;
import com.revature.projects.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/RevBankAPI/v2/")
public class EmployeeController {

    @Autowired
    private final EmployeeRepository employeeRepository;

    @Autowired
    private EmployeeService employeeService;

    public EmployeeController(EmployeeRepository employeeRepository, EmployeeService employeeService) {
        super();
        this.employeeRepository = employeeRepository;
    }


    // to create employee
    /*
     * Body's JSON:
       {
            "employeeName": "Phong",
            "activeStatus": 0
        }
    */
    // http://localhost:8080/RevBankAPI/v2/employees/create
    @PostMapping("employees/create")
    public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee) {
        if (employee != null) {
            return new ResponseEntity<Employee>(employeeService.insertEmployee(employee), HttpStatus.CREATED);
        } else {
            // throw new BadRequestException("Request body does not contain customer data");
            return null;
            // return ResponseEntity.noContent().build();
        }
    }


    // get all employees
    // http://localhost:8080/RevBankAPI/v2/employees/all
    @GetMapping("employees/all")
    public List<Employee> getAllEmployees() {
        return employeeService.listAllEmployees();
    }


    // get employees by employee name
    // http://localhost:8080/RevBankAPI/v2/employees/name/Phong
    @GetMapping("employees/name/{ename}")
    public List<Employee> getEmployeeByName(@PathVariable("ename") String emplName) {
        return employeeService.listAllEmployeesByName(emplName);
    }


    // get employees by employee active status
    // http://localhost:8080/RevBankAPI/v2/employees/active_status/1
    @GetMapping("employees/active_status/{status}")
    public List<Employee> getEmployeeByActiveStatus(@PathVariable("status") int emplActiveStatus) {
        return employeeService.listAllEmployeesByActiveStatus(emplActiveStatus);
    }

}
