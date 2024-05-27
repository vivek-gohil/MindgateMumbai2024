package com.mindgate.main.repository;

import java.util.List;

import com.mindgate.main.domain.EmployeeDetails;

public interface EmployeeDetailsRepositoryInterface {
	public List<EmployeeDetails> getAllEmployeeDetails();

	public boolean saveEmployeeDetails(EmployeeDetails employeeDetails);
}
