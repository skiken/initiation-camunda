package net.guide.springboot.springbootjpacrudexemple.repository;

import net.guide.springboot.springbootjpacrudexemple.model.Employee;
import org.springframework.data.repository.CrudRepository;


public interface EmployeRepository extends CrudRepository<Employee,Long> {

}
