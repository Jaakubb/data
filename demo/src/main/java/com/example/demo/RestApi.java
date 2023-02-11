package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class RestApi {

    @Autowired
    private EmployeeRepository employeeRepository;

    @PostMapping
    public ResponseEntity<String> addUser (@RequestBody Employee employee){

       employeeRepository.addEmployee(employee);
        return ResponseEntity.ok().body("some data");
    }

    @ExceptionHandler({UserExsistException.class})
    public ResponseEntity<String> handleException(){
        return ResponseEntity.unprocessableEntity().body("User already exists");
    }
}
