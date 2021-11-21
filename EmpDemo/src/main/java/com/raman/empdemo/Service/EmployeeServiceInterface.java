package com.raman.empdemo.Service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import com.raman.empdemo.entity.Employee;

public interface EmployeeServiceInterface {

	public Employee addEmp(Employee employee);

	public List<Employee> viewEmp();

	public Optional<Employee> viewEmpById(Long id);

	public Employee updateEmp(Long id, @Valid Employee emp);

	public Boolean deleteEmp(Long id);

	


}
