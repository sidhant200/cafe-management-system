package com.project.First_project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class EmpController {
    @Autowired
    EmployeeService employeeService;

    @GetMapping ("employees")
    public  List<Employee> getAllEmployees(){
        return employeeService.readEmployees();
    }

    @PostMapping ("employees")
    public String createEmployees(@RequestBody Employee employee) {
        return employeeService.createEmployee(employee);

    }
    @DeleteMapping ("employees/{id}")
        public String delEmployees(@PathVariable Long id){
            if (employeeService.deleteEmployee(id))
            return "Deleted succesfully";
            return "not found";
    }
    @PutMapping ("employees/{id}")
    public String updateEmployee(@RequestBody Employee employee , @PathVariable long id){
        employeeService.updateEmployee(employee , id);
        return "succesfully updated";
    }
}
