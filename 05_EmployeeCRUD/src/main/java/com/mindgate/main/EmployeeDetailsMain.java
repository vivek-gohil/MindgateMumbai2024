package com.mindgate.main;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.mindgate.main.configuration.ApplicationConfiguration;
import com.mindgate.main.domain.EmployeeDetails;
import com.mindgate.main.service.EmployeeDetailsService;

public class EmployeeDetailsMain {

	public static void main(String[] args) {

		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(ApplicationConfiguration.class);

		EmployeeDetailsService employeeDetailsService = applicationContext.getBean(EmployeeDetailsService.class);

		Scanner scanner = new Scanner(System.in);
		int choice;
		boolean result;
		String continueChoice;
		do {
			System.out.println("1. Print All Employee Details");
			System.out.println("2. Add New Employee Details");
			System.out.println("Enter your choice");
			choice = scanner.nextInt();
			switch (choice) {
			case 1:
				List<EmployeeDetails> allEmployeeDetails = employeeDetailsService.getAllEmployeeDetails();

				for (EmployeeDetails employeeDetails : allEmployeeDetails) {
					System.out.println(employeeDetails);
				}
				break;
			case 2:
				System.out.println("Enter EmployeeId");
				String employeeId = scanner.next();
				System.out.println("Enter First Name");
				String firstName = scanner.next();
				System.out.println("Enter Last Name");
				String lastName = scanner.next();
				System.out.println("Enter Salary");
				double salary = scanner.nextDouble();
				System.out.println("Enter Email");
				String emailId = scanner.next();
				System.out.println("Enter Gender");
				String gender = scanner.next();
				System.out.println("Enter Contact Number");
				long contactNumber = scanner.nextLong();
				System.out.println("Enter City");
				String city = scanner.next();
				System.out.println("Enter Date Of Birth");
				String strDateOfBirth = scanner.next();
				LocalDate dateOfBirth = LocalDate.parse(strDateOfBirth);

				EmployeeDetails employeeDetails = new EmployeeDetails(employeeId, firstName, lastName, salary, emailId,
						gender, contactNumber, city, dateOfBirth);

				result = employeeDetailsService.saveEmployeeDetails(employeeDetails);

				if (result)
					System.out.println("Employee Details Added Successfully");
				else
					System.out.println("Failed To Add Employee Details");
				break;
			default:
				break;
			}
			System.out.println("Do you want to  continue");
			continueChoice = scanner.next();
		} while (continueChoice.equals("yes"));

	}

}
