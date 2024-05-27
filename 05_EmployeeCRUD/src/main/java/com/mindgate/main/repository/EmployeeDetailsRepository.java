package com.mindgate.main.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.mindgate.main.domain.EmployeeDetails;

@Component
public class EmployeeDetailsRepository implements EmployeeDetailsRepositoryInterface {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	private static final String SELECT_ALL_EMPLOYEES = "SELECT * FROM employee_details";
	private static final String INSERT_NEW_EMPLOYEE = "INSERT INTO employee_details VALUES(?,?,?,?,?,?,?,?,?)";

	@Override
	public List<EmployeeDetails> getAllEmployeeDetails() {
		EmployeeDetailsRowMapper employeeDetailsRowMapper = new EmployeeDetailsRowMapper();
		List<EmployeeDetails> allEmployeeDetails = jdbcTemplate.query(SELECT_ALL_EMPLOYEES, employeeDetailsRowMapper);
		return allEmployeeDetails;
	}

	@Override
	public boolean saveEmployeeDetails(EmployeeDetails employeeDetails) {
		Object[] parameters = { 
				employeeDetails.getEmployeeId(), 
				employeeDetails.getFirstName(),
				employeeDetails.getLastName(), 
				employeeDetails.getSalary(), 
				employeeDetails.getEmail(),
				employeeDetails.getGender(), 
				employeeDetails.getContactNumber(), 
				employeeDetails.getCity(),
				employeeDetails.getDateOfBirth() 
				};

		int resultCount = jdbcTemplate.update(INSERT_NEW_EMPLOYEE, parameters);
		if (resultCount > 0)
			return true;
		return false;
	}

}




