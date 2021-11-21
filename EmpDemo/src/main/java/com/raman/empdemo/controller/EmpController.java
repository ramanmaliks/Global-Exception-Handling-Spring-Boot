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
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import com.raman.empdemo.Service.EmployeeServiceInterface;
import com.raman.empdemo.entity.Employee;
import com.raman.empdemo.exception.BusinessException;
import com.raman.empdemo.exception.ControllerException;

@RestController
@RequestMapping("/emp")
public class EmpController {

	@Autowired
	EmployeeServiceInterface empService;

	@RequestMapping(value = "/emp", method = RequestMethod.POST)
	public ResponseEntity<?> addEmp(@Valid @RequestBody Employee employee) {
		try {
			Employee emp = empService.addEmp(employee);
			return new ResponseEntity<Employee>(emp, HttpStatus.CREATED);
		} catch (BusinessException e) {

			return new ResponseEntity<>(
					new ControllerException(e.getErrorCode(),
							e.getErrorMessage()),
					HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			return new ResponseEntity<>(new ControllerException("611",
					"Something Went in Controller Class " + e.getMessage()),
					HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping(value = "/emp", method = RequestMethod.GET)
	public ResponseEntity<?> viewEmp() {
		try {
			return new ResponseEntity<List<Employee>>(empService.viewEmp(),
					HttpStatus.OK);
		} catch (BusinessException e) {
			return new ResponseEntity<>(
					new ControllerException(e.getErrorCode(),
							e.getErrorMessage()),
					HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			return new ResponseEntity<>(new ControllerException("612",
					"Something Went in Controller Class " + e.getMessage()),
					HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping(value = "/emp/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> viewEmpById(@PathVariable(value = "id") Long id) {
		try {

			return new ResponseEntity<Employee>(empService.viewEmpById(id),
					HttpStatus.OK);

		} catch (BusinessException e) {
			return new ResponseEntity<>(
					new ControllerException(e.getErrorCode(),
							e.getErrorMessage()),
					HttpStatus.BAD_REQUEST);
		} catch (MethodArgumentTypeMismatchException e) {
			return new ResponseEntity<>(new ControllerException("613",
					"Numeric Allowed, Please Enter Correct Id" + e.getMessage()),
					HttpStatus.BAD_REQUEST);
		}		 catch (Exception e) {
			return new ResponseEntity<>(new ControllerException("613",
					"Something Went in Controller Class " + e.getMessage()),
					HttpStatus.BAD_REQUEST);
		}

	}

	@RequestMapping(value = "/emp/{id}", method = RequestMethod.PUT)
	public ResponseEntity<?> updateEmp(@PathVariable(value = "id") Long id,@Valid @RequestBody Employee emp) {
		try {
		return new ResponseEntity<Employee>(empService.updateEmp(id, emp),
				HttpStatus.OK);
		} catch (BusinessException e) {
			return new ResponseEntity<>(
					new ControllerException(e.getErrorCode(),
							e.getErrorMessage()),
					HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			return new ResponseEntity<>(new ControllerException("613",
					"Something Went in Controller Class " + e.getMessage()),
					HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value = "/emp/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteEmp(@PathVariable(value = "id") Long id) {
		empService.deleteEmp(id);
		return new ResponseEntity<>("Deleted", HttpStatus.OK);

	}
}
