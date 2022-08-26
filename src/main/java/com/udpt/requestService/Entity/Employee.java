package com.udpt.requestService.Entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="employee")
public class Employee {
	
	@Id
	@Column(name="employee_id")
	private int employeeID;
	
	@OneToMany(mappedBy="employee")
	private Set<SupportForm> supportForms;

	public Employee() {
		super();
	}

	public Employee(int employeeID) {
		super();
		this.employeeID = employeeID;
	}

	public Employee(int employeeID, Set<SupportForm> supportForms) {
		super();
		this.employeeID = employeeID;
		this.supportForms = supportForms;
	}

	public int getId() {
		return employeeID;
	}

	public void setId(int employeeID) {
		this.employeeID = employeeID;
	}

	public Set<SupportForm> getSupportForms() {
		return supportForms;
	}

	public void setSupportForms(Set<SupportForm> supportForms) {
		this.supportForms = supportForms;
	}
	
	
	
	

}
