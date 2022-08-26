package com.udpt.requestService.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
import java.time.LocalDate;

@Entity
@Table(name="support_request")
public class SupportForm {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="support_request_id")
	private int supportFormID;
	
	@ManyToOne
	@JoinColumn(name="employee_id", referencedColumnName = "employee_id")
	private Employee employee;
	
	@Column(name="date", columnDefinition = "DATE")
	private LocalDate date;
	
	@Column(name="department", length = 500)
	private String department;
	
	@Column(name="approver")
	private int approver;
	
	@Column(name="approve_date", columnDefinition = "DATE")
	private LocalDate approveDate;
	
	@Column(name="is_approved", columnDefinition = "BIT")
	private boolean is_approved;
	
	@Column(name="reason", length = 500)
	private String reason;
	
	@Column(name="director_id")
	private int directorID;
	
	@Column(name="money", columnDefinition = "MONEY")
	private long money;
	
	@Column(name="status", length = 100)
	private String status;
	
	@Column(name="describe", length = 100)
	private String describe;
	
	public SupportForm() {
		super();
	}
	
	

	public SupportForm(Employee employee, LocalDate date, String department, String reason) {
		super();
		this.employee = employee;
		this.date = date;
		this.department = department;
		this.reason = reason;
	}
	

	public SupportForm(int supportFormID, Employee employee, LocalDate date, String department, int approver,
			LocalDate approveDate, boolean is_approved, String reason, int directorID, long money, String status,
			String describe) {
		super();
		this.supportFormID = supportFormID;
		this.employee = employee;
		this.date = date;
		this.department = department;
		this.approver = approver;
		this.approveDate = approveDate;
		this.is_approved = is_approved;
		this.reason = reason;
		this.directorID = directorID;
		this.money = money;
		this.status = status;
		this.describe = describe;
	}



	public long getMoney() {
		return money;
	}



	public void setMoney(long money) {
		this.money = money;
	}



	public int getSupportFormID() {
		return supportFormID;
	}

	public void setSupportFormID(int supportFormID) {
		this.supportFormID = supportFormID;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public int getApprover() {
		return approver;
	}

	public void setApprover(int approver) {
		this.approver = approver;
	}

	public LocalDate getApproveDate() {
		return approveDate;
	}

	public void setApproveDate(LocalDate approveDate) {
		this.approveDate = approveDate;
	}

	public boolean isIs_approved() {
		return is_approved;
	}

	public void setIs_approved(boolean is_approved) {
		this.is_approved = is_approved;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public int getDirectorID() {
		return directorID;
	}

	public void setDirectorID(int directorID) {
		this.directorID = directorID;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDescribe() {
		return describe;
	}

	public void setDescribe(String describe) {
		this.describe = describe;
	}
	
	

}
