package com.mindgate.main.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import org.springframework.jdbc.core.RowMapper;

import com.mindgate.main.domain.EmployeeDetails;

public class EmployeeDetailsRowMapper implements RowMapper<EmployeeDetails> {

	@Override
	public EmployeeDetails mapRow(ResultSet rs, int rowNum) throws SQLException {
		String employeeId = rs.getString("employee_id");
		String firstName = rs.getString("first_name");
		String lastName = rs.getString("last_name");
		double salary = rs.getDouble("salary");
		String email = rs.getString("email_id");
		String gender = rs.getString("gender");
		long contactNumber = rs.getLong("contact_number");
		String city = rs.getString("city");
		LocalDate dateOfBirth = rs.getDate("date_of_birth").toLocalDate();

		EmployeeDetails employeeDetails = new EmployeeDetails(employeeId, firstName, lastName, salary, email, gender,
				contactNumber, city, dateOfBirth);

		return employeeDetails;
	}

}
