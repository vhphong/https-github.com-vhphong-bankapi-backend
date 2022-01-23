package com.revature.projects.repositories;

import com.revature.projects.models.Customer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

// @Repository   : no need @Repository annotation because JpaRepository already defined @Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
