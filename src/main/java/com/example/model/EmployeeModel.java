package com.example.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class EmployeeModel {
    private static EmployeeModel instance = new EmployeeModel();

    public static EmployeeModel getInstance() {
        return instance;
    }

    private final List<Employee> employeeList;

    private EmployeeModel() {
        this.employeeList = new ArrayList<>();
        this.employeeList.add(new Employee(String.valueOf(this.employeeList.size()), "name", LocalDate.now()));
        this.employeeList.add(new Employee(String.valueOf(this.employeeList.size()), "name2", LocalDate.now()));
        this.employeeList.add(new Employee(String.valueOf(this.employeeList.size()), "name3", LocalDate.now()));

    }

    public boolean add(Employee emp) {
        return this.employeeList.add(emp);
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public List<String> list() {
        return employeeList.stream().map(Employee::getName).collect(Collectors.toList());
    }

    public Employee deleteEmployee(String id) {
        for (int i = 0; i < this.employeeList.size(); i++) {
            if(this.employeeList.get(i).getId().equalsIgnoreCase(id)){
                return this.employeeList.remove(i);
            }
        }
        return null;
    }

    public Optional<Employee> get(String id) {
        return this.employeeList.stream().filter(employee -> employee.getId().equalsIgnoreCase(id)).findFirst();
    }

    public boolean edit(String id, Employee employee) {
        for (Employee value : this.employeeList) {
            if (value.getId().equalsIgnoreCase(id)) {
                value.setName(employee.getName());
                return true;
            }
        }
        return false;
    }
}
