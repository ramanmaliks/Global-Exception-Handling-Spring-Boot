package com.raman.empdemo.controller;

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

import com.raman.empdemo.Service.EmployeeServiceInterface;
import com.raman.empdemo.entity.Employee;

@RestController
@RequestMapping("/emp")
public class EmpController {

	@Autowired
	EmployeeServiceInterface empService;
	
	@RequestMapping(value="/emp", method = RequestMethod.POST)
	public ResponseEntity<Employee> addEmp(@Valid @RequestBody Employee employee){
		Employee emp = empService.addEmp(employee);
		return new ResponseEntity<Employee>(emp, HttpStatus.CREATED);
	}
	
	@RequestMapping(value="/emp", method = RequestMethod.GET)
	public ResponseEntity<List<Employee>> viewEmp()
	{
		return new ResponseEntity<List<Employee>>(empService.viewEmp(), HttpStatus.OK);
	}
	
	@RequestMapping(value="/emp/{id}", method = RequestMethod.GET)
	public ResponseEntity<Optional<Employee>> viewEmpById(@PathVariable(value="id") Long id)
	{
		return new ResponseEntity<Optional<Employee>>(empService.viewEmpById(id), HttpStatus.OK);
	}
	
	@RequestMapping(value="/emp/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Employee> updateEmp(@PathVariable(value="id") Long id,@Valid @RequestBody Employee emp){
		return new ResponseEntity<Employee>(empService.updateEmp(id,emp), HttpStatus.OK);
		
	}
	@RequestMapping(value="/emp/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteEmp(@PathVariable(value="id")Long id){
		return new ResponseEntity<>(empService.deleteEmp(id) ? "Deleted "+id : "Id doesnot Exit",HttpStatus.OK);
		
	}
}
