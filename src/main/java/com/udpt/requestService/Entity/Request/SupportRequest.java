package com.udpt.requestService.Entity.Request;

import java.time.LocalDate;

import com.udpt.requestService.Entity.Employee;

public class SupportRequest {
	private int supportFormID;
	private Employee employee;
	private LocalDate date;
	private String department;
	private int approver;
	private LocalDate approveDate;
	private boolean is_approved;
	private String reason;
	private int directorID;
	private long money;
	private String status;
	private String describe;
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
	public long getMoney() {
		return money;
	}
	public void setMoney(long money) {
		this.money = money;
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
