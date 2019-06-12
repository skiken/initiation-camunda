package net.guide.springboot.springbootjpacrudexemple.controller;


import net.guide.springboot.springbootjpacrudexemple.model.Employee;
import net.guide.springboot.springbootjpacrudexemple.repository.EmployeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class EmployeeController {

    @Autowired
    EmployeRepository employeRepository;



    @PostMapping(value="employee/add")
    public Employee addCustmer( @RequestBody Employee employee){
        Employee _employee = employeRepository.save(new Employee(employee.getFirstName(), employee.getLastName(),employee.getEmailId()));
        return _employee;

    }

    @GetMapping(value="employee/find")
    public List<Employee> findEmployees(){
        return (List<Employee>) employeRepository.findAll();


    }
    @GetMapping(value="employee/find/{id}")
    public Optional<Employee> findEmployeeById(@PathVariable("id") Long id){
        return employeRepository.findById(id);
    }

    @DeleteMapping(value="employee/deleteAll")
    public void deleteAll(){
        employeRepository.deleteAll();
    }

    @DeleteMapping(value="employee/delete/{id}")
    public void deleteById(@PathVariable("id")  Long id){
        employeRepository.deleteById(id);
    }

    @PutMapping(value="employee/update/{id}")
    public ResponseEntity<Employee> updateEmploye(@RequestBody Employee employee, @PathVariable("id") long id){
       Optional<Employee> employee_data= employeRepository.findById(id);
        if (employee_data.isPresent()) {
            Employee employee_up=employee_data.get();
            employee_up.setFirstName(employee.getFirstName());
            employee_up.setEmailId((employee.getEmailId()));
            employee_up.setLastName(employee.getLastName());
            return new ResponseEntity<>(employeRepository.save(employee_up), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }




    }


}
