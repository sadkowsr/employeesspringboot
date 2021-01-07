package org.sadkowski.employees.service;

import org.sadkowski.employees.Model.Employee;
import org.sadkowski.employees.error.EmployeeNotFoundException;
import org.sadkowski.employees.repository.EmployeeRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EmployeeService {

    EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Employee getEmployeeById(Integer id) {
        return employeeRepository.
                        findById(id).
                        orElseThrow(() -> new EmployeeNotFoundException(id));
    }

    public List<Employee> getEmployees(Integer pageNumber, Integer size) {
        List<Employee> employees = employeeRepository.findAll(PageRequest.of(pageNumber, size)).toList();
        return employees;
    }

    public Employee addEmployee(Employee newEmployee) {
        return employeeRepository.save(newEmployee);
    }

    public void deleteEmployee(Integer employeeId) {
        employeeRepository.deleteById(employeeId);
    }

    public Employee updateEmployee(Employee newEmployee, Integer employeeId) {
        return employeeRepository.findById(employeeId)
                .map(employee -> {
                    employee.setName(newEmployee.getName());
                    employee.setManagerId(newEmployee.getManagerId());
                    return employeeRepository.save(employee);
                })
                .orElseGet(() -> {
                    return employeeRepository.save(newEmployee);
                });

    }
}
