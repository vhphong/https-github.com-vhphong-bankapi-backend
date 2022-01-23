package com.revature.projects.controllers;

import com.revature.projects.exceptions.BadRequestException;
import com.revature.projects.models.Customer;
import com.revature.projects.services.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/RevBankAPI/v2/")
public class CustomerController {

    private CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        super();
        this.customerService = customerService;
    }


    // build create employee REST API
    /*
     * Body's JSON:
     *  {
            "name": "Phong",
            "email": "phong@revbank.com",
            "dob": "1999-12-31",
            "mobile": "1-800-fakemobile",
            "address": "222 A St",
            "password": "phong1"
        }
     */
    @PostMapping("customers")
    public ResponseEntity<Customer> saveCustomer(@RequestBody Customer customer) {
        if (customer != null) {
            return new ResponseEntity<Customer>(customerService.insertCustomer(customer), HttpStatus.CREATED);
        } else {
//            throw new BadRequestException("Request body does not contain customer data");
            return null;
        }
    }


    // build get all customers REST API
    @GetMapping("customers")
    public List<Customer> getAllCustomers() {
        return customerService.listAllCustomers();
    }


    // build get a customer by Id REST API
    // http://localhost:8080/RevBankAPI/v2/customers/1
    @GetMapping("/customers/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable("id") long cId) {
        return new ResponseEntity<Customer>(customerService.listCustomerById(cId), HttpStatus.OK);
    }


    // build update customer REST API
    @PutMapping("/customers/{id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable("id") long cId,
                                                   @RequestBody Customer customer) {
        return new ResponseEntity<Customer>(customerService.modifyCustomer(customer, cId), HttpStatus.OK);
    }


    // build delete customer REST API
    @DeleteMapping("/customers/{id}")
    public ResponseEntity<String> deleteCustomer(@PathVariable("id") long cId) {
        if (cId > 0) {
            Boolean isDeleted = customerService.removeCustomer(cId);

            if (isDeleted) {
                return new ResponseEntity<String>("Customer id: " + cId + " deleted successfully.", HttpStatus.OK);
            } else {
                return new ResponseEntity<String>("Customer id: " + cId + " was not found to delete.", HttpStatus.NOT_FOUND);
            }
        } else {
            return new ResponseEntity<String>("Customer id: " + cId + " is invalid.", HttpStatus.NOT_FOUND);
        }
    }
}