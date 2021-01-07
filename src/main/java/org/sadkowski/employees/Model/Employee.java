package org.sadkowski.employees.Model;

import java.util.Objects;
import javax.persistence.*;


@Entity
@Table(name="e")
public class Employee {

    @Id
    @GeneratedValue
    @Column(name = "Emp_id")
    private Integer id;

    @Column(name = "Emp_name")
    private String name;

    @Column(name = "Manager_id")
    private Integer managerId;

    public Employee() {
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





}
