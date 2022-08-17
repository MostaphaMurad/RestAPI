package com.RestAPI.Services;

import com.RestAPI.Models.Employee;

import java.util.List;

public interface EmployeeServices {
    public abstract List<Employee> getEmployees();
    public abstract Employee saveEmployee(Employee employee );
    public abstract Employee getEmployeeById(int id);
    public abstract Employee updateEmployee(Employee employee,int id);
    public abstract void deleteEmployee(int id);
}
