package com.mindgate.main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mindgate.main.domain.EmployeeDetails;
import com.mindgate.main.repository.EmployeeDetailsRepositoryInterface;

@Component
public class EmployeeDetailsService implements EmployeeDetailsServiceInterface {

	@Autowired
	private EmployeeDetailsRepositoryInterface employeeDetailsRepositoryInterface;

	@Override
	public List<EmployeeDetails> getAllEmployeeDetails() {
		return employeeDetailsRepositoryInterface.getAllEmployeeDetails();
	}

	@Override
	public boolean saveEmployeeDetails(EmployeeDetails employeeDetails) {
		return employeeDetailsRepositoryInterface.saveEmployeeDetails(employeeDetails);
	}

}
