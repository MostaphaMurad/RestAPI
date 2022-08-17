package com.RestAPI.Controllers;

import com.RestAPI.Models.Employee;
import com.RestAPI.ServicesImp.EmployeeServicesImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees/api")
public class EmployeeController {
    @Autowired private EmployeeServicesImp empService;
    @PostMapping()
    public ResponseEntity<Employee>saveEmployee(@RequestBody Employee employee){
        return new ResponseEntity<Employee>(empService.saveEmployee(employee), HttpStatus.CREATED);
    }
    @GetMapping("/emps")
    public List<Employee>employees(){
        return empService.getEmployees();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Employee>getEmployeeById(@PathVariable("id")int id){
        return new ResponseEntity<>(empService.getEmployeeById(id),HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Employee>updateEmployee(@PathVariable("id")int id,@RequestBody Employee employee){
        return new ResponseEntity<>(empService.updateEmployee(employee,id),HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String>deleteEmployee(@PathVariable("id")int id){
        empService.deleteEmployee(id);
        return new ResponseEntity<>("Employee deleted successfully!!",HttpStatus.OK);
    }
}
