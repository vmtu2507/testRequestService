package com.udpt.requestService.Service;



import com.udpt.requestService.Entity.Employee;
import com.udpt.requestService.Entity.SupportForm;
import com.udpt.requestService.Entity.Request.SupportRequest;
import com.udpt.requestService.HandleException.DuplicateException;
import com.udpt.requestService.HandleException.NotFoundException;
import com.udpt.requestService.Repository.SupportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;

import java.util.List;
import java.util.Optional;


public class SupportService {

	@Autowired
	private SupportRepository suppportRepository;

	@Autowired
	private RestTemplate restTemplate;

	private SupportRequest supportRequest;

	private int supportFormID;

	private Employee employee;

	public void setSupportFormID(int supportFormID) {
		this.supportFormID = supportFormID;
	}

	public void setEmployeeeID(Employee employee) {
		this.employee = employee;
	}

	public void setSupportRequest(SupportRequest supportRequest) {
		this.supportRequest = supportRequest;
	}

	public List<SupportForm> getListSupportRequest() {
		return suppportRepository.findAll();
	}

	public SupportForm getSupportRequestByID() {
		Optional<SupportForm> optionalSupportForm = suppportRepository.findBySupportID(supportFormID);
		if (!optionalSupportForm.isPresent()) {
			throw new NotFoundException("Not found Support Request has ID: " + supportFormID);
		}

		return optionalSupportForm.get();
	}

	public SupportForm getSupportRequestByEmployeeID() {
		Optional<SupportForm> optionalSupportForm = suppportRepository.findByEmployeeID(employee);
		if (!optionalSupportForm.isPresent()) {
			throw new NotFoundException("Not found Support Request has employee ID: " + employee);
		}

		return optionalSupportForm.get();
	}

	public String creatNewSupportRequest() {

		SupportForm supportForm = new SupportForm();
		supportForm.setEmployee(supportRequest.getEmployee());
		supportForm.setDate(LocalDate.now());
		supportForm.setDepartment(supportRequest.getDepartment());
		supportForm.setReason(supportRequest.getReason());


		suppportRepository.save(supportForm);

		Optional<SupportForm> optionalSupportForm = suppportRepository.findByEmployeeID(supportRequest.getEmployee());
		if (!optionalSupportForm.isPresent()) {
			throw new NotFoundException("Support Request form of employee has ID " + supportRequest.getEmployee() + "was not created");
		}
		String syncResult = restTemplate.postForObject("http://localhost:8002/supportRequest/createNewRequest",
				optionalSupportForm.get().getSupportFormID(), String.class);
		return "Support Request form of employee has ID " + supportForm.getEmployee() + " was created";

	}
	
	public String verifySupportRequest() {
//        Optional<SupportForm> optionalSupportForm = suppportRepository.findByEmployeeID(supportRequest.getEmployee());
//        if (!optionalSupportForm.isPresent()) {
//            throw new NotFoundException("Not found Support Reuqest form of employee has ID "+ supportRequest.getEmployee());
//        }

        SupportForm supportForm = new SupportForm();
		supportForm.setApprover(supportRequest.getApprover());
		supportForm.setApproveDate(supportRequest.getApproveDate());
		supportForm.setIs_approved(supportRequest.isIs_approved());
		supportForm.setDirectorID(supportRequest.getDirectorID());
		supportForm.setMoney(supportRequest.getMoney());
		supportForm.setStatus(supportRequest.getStatus());
		supportForm.setDescribe(supportRequest.getDescribe());
		
		
		suppportRepository.save(supportForm);

        return "Support Reuqest form has ID "+supportForm.getSupportFormID()+" was updated";
    }

}
