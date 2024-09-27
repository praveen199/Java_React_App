package com.spring.boot.controller;

import com.spring.boot.model.Employee;
import com.spring.boot.repository.EmployeeRepository;
import java.util.Optional;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

  private EmployeeRepository employeeRepository;

  // Build Add Employee REST API
  @PostMapping
  public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee){
    Employee savedEmployee = employeeRepository.save(employee);
    return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
  }

  // Build Get Employee REST API
  @GetMapping("{id}")
  public ResponseEntity<Optional<Employee>> getEmployeeById(@PathVariable("id") Long employeeId){
    Optional<Employee> employeeDto = employeeRepository.findById(employeeId);
    return ResponseEntity.ok(employeeDto);
  }

  // Build Get All Employees REST API
  @GetMapping
  public ResponseEntity<List<Employee>> getAllEmployees(){
    List<Employee> employees = employeeRepository.findAll();
    return ResponseEntity.ok(employees);
  }

  // Build Update Employee REST API
  @PutMapping("{id}")
  public ResponseEntity<Employee> updateEmployee(@PathVariable("id") Long employeeId,
      @RequestBody Employee updatedEmployee){
    Employee employeeDto = employeeRepository.save(updatedEmployee);
    return ResponseEntity.ok(employeeDto);
  }

  // Build Delete Employee REST API
  @DeleteMapping("{id}")
  public ResponseEntity<String> deleteEmployee(@PathVariable("id") Long employeeId){
    employeeRepository.deleteById(employeeId);
    return ResponseEntity.ok("Employee deleted successfully!.");
  }
}