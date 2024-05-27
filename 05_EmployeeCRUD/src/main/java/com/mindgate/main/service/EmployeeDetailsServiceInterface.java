package com.mindgate.main.service;

import java.util.List;

import com.mindgate.main.domain.EmployeeDetails;

public interface EmployeeDetailsServiceInterface {
	public List<EmployeeDetails> getAllEmployeeDetails();

	public boolean saveEmployeeDetails(EmployeeDetails employeeDetails);;
}
