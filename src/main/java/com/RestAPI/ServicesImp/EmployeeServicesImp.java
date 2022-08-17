package com.RestAPI.ServicesImp;

import com.RestAPI.Exceptions.ResourceNotFound;
import com.RestAPI.Models.Employee;
import com.RestAPI.Repositories.EmployeeRepository;
import com.RestAPI.Services.EmployeeServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServicesImp implements EmployeeServices {
    @Autowired private EmployeeRepository employeeRepository;
    @Override
    public List<Employee> getEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Employee getEmployeeById(int id) {
       Optional <Employee> employee=employeeRepository.findById(id);
       if(employee.isPresent()){
           return employee.get();
       }
       else{
           throw  new ResourceNotFound("Not found Employee","Employee","Empoyee +'id'",employee);
       }
    }

    @Override
    public void deleteEmployee(int id) {
        employeeRepository.findById(id).orElseThrow(
                ()->new ResourceNotFound("Not found Employee","Employee","Employee")
        );
        employeeRepository.deleteById(id);
    }

    @Override
    public Employee updateEmployee(Employee employee, int id) {
        Employee foundEmp=employeeRepository.findById(id).orElseThrow(
                ()->new ResourceNotFound("Not found Employee","Employee","Empoyee +'id'",employee)
        );
        foundEmp.setEmail(employee.getEmail());
        foundEmp.setFirstName(employee.getFirstName());
        foundEmp.setLastName(employee.getLastName());
        employeeRepository.save(foundEmp);
        return foundEmp;
    }
}
