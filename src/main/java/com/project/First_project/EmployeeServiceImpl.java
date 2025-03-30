package com.project.First_project;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private Emprepository employeerepository;

    @Override
    public String createEmployee(Employee employee) {
        EmpEntity empEntity = new EmpEntity();
        BeanUtils.copyProperties(employee,empEntity);
        employeerepository.save(empEntity);
        return "Saved succesfully";
    }

    @Override
    public List<Employee> readEmployees() {
       List<EmpEntity> empEntities = employeerepository.findAll();
        List<Employee> employees = new ArrayList<>();
        for(EmpEntity empEntity: empEntities){
            Employee emp = new Employee();
            emp.setName(empEntity.getName());
            emp.setPhone(empEntity.getPhone());
            emp.setId(empEntity.getId());
            emp.setEmail(empEntity.getEmail());
           employees.add(emp);
        }

        return employees;
    }

    @Override
    public boolean deleteEmployee(Long id) {
      //  employees.remove(id);
        employeerepository.deleteById(id);
        return true;
    }

    @Override
    public Employee updateEmployee(Employee employee, long id) {
        EmpEntity empEntity = employeerepository.findById(id).get();
        empEntity.setName(employee.getName());
        employeerepository.save(empEntity);

        return null;
    }
}
