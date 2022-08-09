package com.shastri.service;

import java.util.List;

import com.shastri.model.Employee;

public interface EmployeeService {
	public List<Employee> getEmployees();
	Employee saveEmployee(Employee employee);
	Employee getEmployee(long id);
	 void deleteEmpByid(long id);
	 Employee updateEmployee(Employee employee);

}
