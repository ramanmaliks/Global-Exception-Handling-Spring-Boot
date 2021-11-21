package com.raman.empdemo.Service;

import java.util.List;
import java.util.Optional;

import javax.persistence.Temporal;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.raman.empdemo.entity.Employee;
import com.raman.empdemo.repository.EmployeeRepository;
@Service
public class EmployeeService implements EmployeeServiceInterface {

	@Autowired
	EmployeeRepository empRepo;

	@Override
	public Employee addEmp(Employee employee) {
			return empRepo.save(employee);
	}

	@Override
	public List<Employee> viewEmp() {
		return empRepo.findAll();
	}

	@Override
	public Optional<Employee> viewEmpById(Long id) {
		return empRepo.findById(id);
	}

	@Override
	public Employee updateEmp(Long id, @Valid Employee emp) {
	//	Employee emp1 = new Employee();
			if(empRepo.existsById(id)) {
				emp.setId(id);
//		emp1.setEmpName(emp.getEmpName());
	//	emp1.setEmpCity(emp.getEmpCity());
		empRepo.save(emp);
			}
		return emp;
	}

	@Override
	public Boolean deleteEmp(Long id) {
		if(empRepo.existsById(id)) {
			empRepo.deleteById(id);
			return true;
		}
		return false;
	}

	

}
