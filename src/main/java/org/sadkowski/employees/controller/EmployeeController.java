package org.sadkowski.employees.controller;

import org.sadkowski.employees.DTO.EmployeeDto;
import org.sadkowski.employees.Model.Employee;
import org.sadkowski.employees.mapper.EmployeeMapper;
import org.sadkowski.employees.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/employee")
public class EmployeeController {

    EmployeeService employeeService;


    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping({""})
    public List<EmployeeDto> getEmployees(@RequestParam(defaultValue = "0", required=false) Integer pageNumber, @RequestParam(defaultValue = "10", required = false) Integer size){
                List<Employee> emp = employeeService.getEmployees(pageNumber,size);
                List<EmployeeDto> foundEmployees = EmployeeMapper.INSTANCE.map(emp);
        return foundEmployees;
    }

    @GetMapping("/{employeeId}")
    public EmployeeDto getEmployee(@PathVariable Integer employeeId){
        EmployeeDto foundEmployee = EmployeeMapper.INSTANCE.employeToEmployeDto(
                employeeService.getEmployeeById(employeeId));
        return foundEmployee;
    }

    @PostMapping("")
    public ResponseEntity<EmployeeDto> createEmploye(@RequestBody EmployeeDto newEmployee){
        EmployeeDto addedEmployee = EmployeeMapper.INSTANCE.employeToEmployeDto(
                employeeService.addEmployee(
                        EmployeeMapper.INSTANCE.employeDtoToEmploye(newEmployee)
                )
        );
        return new ResponseEntity<EmployeeDto>(addedEmployee, HttpStatus.CREATED);
    }

    @DeleteMapping("/{employeeId}")
    public void delEmploye(@PathVariable Integer employeeId){
        employeeService.deleteEmployee(employeeId);
    }

    @PutMapping("/{employeeId}")
    public Employee updateEmploye(@RequestBody EmployeeDto newEmployee, @PathVariable Integer employeeId){
        return employeeService.updateEmployee(EmployeeMapper.INSTANCE.employeDtoToEmploye(newEmployee),employeeId);
    }
    
}
