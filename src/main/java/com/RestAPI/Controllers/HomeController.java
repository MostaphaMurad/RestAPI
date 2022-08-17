package com.RestAPI.Controllers;

import com.RestAPI.Models.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class HomeController{
    @GetMapping(value = "/home",produces = MediaType.APPLICATION_JSON_VALUE)
    public Map home(){
        Map<String ,Integer> mpp=new HashMap<>();
        mpp.put("hello",5);
        mpp.put("ali",3);
        mpp.put("gad",4);
        mpp.put("mostafa",7);
        return mpp;
    }
    @GetMapping(value = "/student",produces =MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Student>> student(){
        List<Student>students=new ArrayList<>();
        Student student=new Student("mostafa","murad");
        students.add(student);
        student=new Student("gad","mohamed");
        students.add(student);
        return new ResponseEntity<>(students, HttpStatus.OK);
    }
}
