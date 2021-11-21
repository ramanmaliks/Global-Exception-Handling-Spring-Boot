package com.raman.empdemoglobexcp.Service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;

import com.raman.empdemoglobexcp.entity.Employee;

public interface EmployeeServiceInterface {

	public Employee addEmp(Employee employee);

	public List<Employee> viewEmp();

	public Employee viewEmpById(Long id);

	public Employee updateEmp(Long id, @Valid Employee emp);

	public void deleteEmp(Long id);	


}
