package com.mindgate.main.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.mindgate.main.repository.EmployeeDetailsRepository;
import com.mindgate.main.service.EmployeeDetailsService;

@Configuration
public class ApplicationConfiguration {
	private static final String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private static final String driver = "oracle.jdbc.driver.OracleDriver";
	private static final String user = "training";
	private static final String password = "training123";

	@Bean
	public EmployeeDetailsService getEmployeeDetailsService() {
		EmployeeDetailsService employeeDetailsService = new EmployeeDetailsService();
		return employeeDetailsService;
	}

	@Bean
	public EmployeeDetailsRepository getEmployeeDetailsRepository() {
		return new EmployeeDetailsRepository();
	}

	@Bean
	public JdbcTemplate getJdbcTemplate() {
		DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();

		driverManagerDataSource.setDriverClassName(driver);
		driverManagerDataSource.setUrl(url);
		driverManagerDataSource.setUsername(user);
		driverManagerDataSource.setPassword(password);

		JdbcTemplate jdbcTemplate = new JdbcTemplate(driverManagerDataSource);

		return jdbcTemplate;
	}

}
