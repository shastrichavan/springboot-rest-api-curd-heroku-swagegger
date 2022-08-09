package com.shastri.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shastri.model.Employee;
import com.shastri.repository.EmployeeRepository;

@Service

public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository eRepository;

	public List<Employee> getEmployees() {

		return eRepository.findAll();

	}

	@Override
	public Employee saveEmployee(Employee employee) {
		return eRepository.save(employee);
	}

	public Employee getEmployee(long id) {

		Optional<Employee> op1 = eRepository.findById(id);
		if (op1.isPresent()) {
			return op1.get();

		} else {
			throw new RuntimeException("Employye not present with given id"+id);

		}
	}
	@Override
	public void deleteEmpByid(long id) {
		eRepository.deleteById(id);
		
	}

	@Override
	public Employee updateEmployee(Employee employee) {
		return eRepository.save(employee);
	}

}
