package com.raman.empdemo.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="emp")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdDt","updateDt"},allowGetters = true)
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name="empname",nullable = false)
	private String empName;
	
	@NotBlank
	@Column
	private String empCity;
		
	@Column(nullable = false, updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	@CreatedDate
	private Date createdDt;
	
	@Column(nullable=false)
	@Temporal(TemporalType.TIMESTAMP)
	@LastModifiedDate
	private Date updatedDt;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmpCity() {
		return empCity;
	}

	public void setEmpCity(String empCity) {
		this.empCity = empCity;
	}

	public Date getCreatedDt() {
		return createdDt;
	}

	public void setCreatedDt(Date createdDt) {
		this.createdDt = createdDt;
	}

	public Date getUpdatedDt() {
		return updatedDt;
	}

	public void setUpdatedDt(Date updatedDt) {
		this.updatedDt = updatedDt;
	}

	public Employee() {
		super();
		
	}
	
	public Employee(Long id, String empName, @NotBlank String empCity,
			Date createdDt, Date updatedDt) {
		super();
		this.id = id;
		this.empName = empName;
		this.empCity = empCity;
		this.createdDt = createdDt;
		this.updatedDt = updatedDt;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", empName=" + empName + ", empCity="
				+ empCity + ", createdDt=" + createdDt + ", updatedDt="
				+ updatedDt + "]";
	}
}
