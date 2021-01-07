package org.sadkowski.employees.DTO;

import org.springframework.stereotype.Component;

@Component
public class EmployeeDto {
    public EmployeeDto(Integer id, String name, Integer managerId) {
        this.id = id;
        this.name = name;
        this.managerId = managerId;
    }

    public EmployeeDto() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getManagerId() {
        return managerId;
    }

    public void setManagerId(Integer managerId) {
        this.managerId = managerId;
    }

    private Integer id;
    private String name;
    private Integer managerId;

}
