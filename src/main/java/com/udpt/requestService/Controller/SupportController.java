package com.udpt.requestService.Controller;

import com.udpt.requestService.Entity.Employee;
import com.udpt.requestService.Entity.SupportForm;
import com.udpt.requestService.Entity.Request.SupportRequest;
import com.udpt.requestService.Service.SupportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RestController
@RequestMapping("/supportRequest")
@CrossOrigin(origins = "http://localhost:3000")
public class SupportController {
	
	@Autowired
	private SupportService supportService;

	@GetMapping("/all")
	public List<SupportForm> getAllSupportRequests() {
		return supportService.getListSupportRequest();
	}

	@PostMapping("/findBySupportID")
	public SupportForm getSupportRequestBySupportID(@RequestBody int supportFormID) {
		supportService.setSupportFormID(supportFormID);
		return supportService.getSupportRequestByID();
	}

	@PostMapping("/findByEmployeeID")
	public SupportForm getSupportRequestByEmployeeID(@RequestBody Employee employee) {
		supportService.setEmployeeeID(employee);
		return supportService.getSupportRequestByEmployeeID();
	}

	@PostMapping("/createNewRequest")
	public String createNewSupport(@RequestBody SupportRequest supportRequest) {
		supportService.setSupportRequest(supportRequest);
		return supportService.creatNewSupportRequest();
	}

	@PostMapping("/verifyRequest")
	public String verifySupportRequest(@RequestBody SupportRequest supportRequest) {
		supportService.setSupportRequest(supportRequest);
		return supportService.verifySupportRequest();
	}

}
