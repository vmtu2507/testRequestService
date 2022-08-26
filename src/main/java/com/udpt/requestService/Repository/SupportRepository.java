package com.udpt.requestService.Repository;

import com.udpt.requestService.Entity.Employee;
import com.udpt.requestService.Entity.SupportForm;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface SupportRepository extends JpaRepository<SupportForm, Integer> {
	
	
	Optional<SupportForm> findBySupportID(int supoortFormID);

    Optional<SupportForm> findByEmployeeID(Employee employee);


}
