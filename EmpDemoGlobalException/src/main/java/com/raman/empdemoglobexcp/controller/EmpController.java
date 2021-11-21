package com.raman.empdemoglobexcp.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import com.raman.empdemoglobexcp.Service.EmployeeServiceInterface;
import com.raman.empdemoglobexcp.entity.Employee;
import com.raman.empdemoglobexcp.exception.BusinessException;
import com.raman.empdemoglobexcp.exception.ControllerException;

@RestController
@RequestMapping("/emp")
public class EmpController {

	@Autowired
	EmployeeServiceInterface empService;

	@RequestMapping(value = "/emp", method = RequestMethod.POST)
	public ResponseEntity<?> addEmp(@Valid @RequestBody Employee employee) {
		Employee emp = empService.addEmp(employee);
		return new ResponseEntity<Employee>(emp, HttpStatus.CREATED);

	}

	@RequestMapping(value = "/emp", method = RequestMethod.GET)
	public ResponseEntity<?> viewEmp() {
		return new ResponseEntity<List<Employee>>(empService.viewEmp(),
				HttpStatus.OK);
	}

	@RequestMapping(value = "/emp/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> viewEmpById(@PathVariable(value = "id") Long id) {
		return new ResponseEntity<Employee>(empService.viewEmpById(id),
				HttpStatus.OK);
	}

	@RequestMapping(value = "/emp/{id}", method = RequestMethod.PUT)
	public ResponseEntity<?> updateEmp(@PathVariable(value = "id") Long id,
			@Valid @RequestBody Employee emp) {
		return new ResponseEntity<Employee>(empService.updateEmp(id, emp),
				HttpStatus.OK);
	}

	@RequestMapping(value = "/emp/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteEmp(@PathVariable(value = "id") Long id) {
		empService.deleteEmp(id);
		return new ResponseEntity<>("Deleted", HttpStatus.OK);

	}
}
