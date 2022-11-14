package com.luyenlaptrinh.templateproject.controller;

import com.luyenlaptrinh.templateproject.payload.request.CreateEmployeeReq;
import com.luyenlaptrinh.templateproject.payload.request.UpdateEmployeeReq;
import com.luyenlaptrinh.templateproject.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/get-all")
    public ResponseEntity<?> getListEmployees(){
        return ResponseEntity.ok(employeeService.getAll());
    }

    @GetMapping("/get-by-employee-id")
    public ResponseEntity<?> getEmployeeById(@RequestParam Long employeeId){
        return ResponseEntity.ok(employeeService.getByEmployeeId(employeeId));
    }

    @PostMapping("/create")
    public ResponseEntity<?> createEmployee(@Valid @RequestBody CreateEmployeeReq req){
        return ResponseEntity.ok(employeeService.create(req));
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateEmployee(@Valid @RequestBody UpdateEmployeeReq req){
        return ResponseEntity.ok(employeeService.update(req));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteEmployee(@RequestParam Long employeeId){
        employeeService.delete(employeeId);
        return ResponseEntity.ok("Successful");
    }
}
