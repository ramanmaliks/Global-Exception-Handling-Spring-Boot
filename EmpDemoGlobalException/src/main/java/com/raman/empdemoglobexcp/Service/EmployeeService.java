package com.raman.empdemoglobexcp.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import javax.persistence.Temporal;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.raman.empdemoglobexcp.entity.Employee;
import com.raman.empdemoglobexcp.exception.BusinessException;
import com.raman.empdemoglobexcp.exception.EmptyInputException;
import com.raman.empdemoglobexcp.repository.EmployeeRepository;
@Service
public class EmployeeService implements EmployeeServiceInterface {

	@Autowired
	EmployeeRepository empRepo;

	@Override
	public Employee addEmp(Employee employee) {

		if (employee.getEmpName().isEmpty()
				|| employee.getEmpName().trim().length() == 0) {
			throw new EmptyInputException("601",
					"Employee Name is Blank, Please Enter Name");
		}
		try {
			Employee savedEmployee = empRepo.save(employee);
			return savedEmployee;
		} catch (IllegalArgumentException e) {
			throw new BusinessException("602",
					"Given Employee is Null" + e.getMessage());
		} catch (Exception e) {
			throw new BusinessException("603",
					"Something went wrong in Service Layer while saving a record "
							+ e.getMessage());
		}
	}

	@Override
	public List<Employee> viewEmp() {
		try {
			List<Employee> empList = empRepo.findAll();
			return empList;
		} catch (NullPointerException e) {
			throw new BusinessException("605",
					"No Records Found in Database" + e.getMessage());
		} catch (Exception e) {
			throw new BusinessException("606",
					"Something went wrong in Service Layer" + e.getMessage());
		}
	}

	@Override
	public Employee viewEmpById(Long id) {
		return empRepo.findById(id).get();
	}

	@Override
	public Employee updateEmp(Long id, @Valid Employee emp) {
		
		if (!empRepo.existsById(id)) {
			System.out.println("update**************");
			throw new BusinessException("622","Employee doesn't Exits with the given ID");
		}

		try {
			emp.setId(id);
			empRepo.save(emp);
			return emp;

		} catch (IllegalArgumentException e) {
			throw new BusinessException("607",
					"Employee ID does not exists in Database Record"
							+ e.getMessage());
		} catch (NoSuchElementException e) {
			System.out.println("update**************2");
			throw new BusinessException("608",
					"Employee ID given is Null" + e.getMessage());
		}
	}

	@Override
	public void deleteEmp(Long id) {

		if (!empRepo.existsById(id)) {
			
		}
		try {
			empRepo.deleteById(id);
		} catch (IllegalArgumentException e) {
			throw new BusinessException("607",
					"Employee ID does not exists in Database Record"
							+ e.getMessage());
		} catch (NoSuchElementException e) {
			throw new BusinessException("608", "Employee ID given is Null");
		}

	}
}
