package com.shastri.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.shastri.model.Employee;
import com.shastri.service.EmployeeServiceImpl;

//controller + response body=@RestController
@RestController
@RequestMapping("/api")
public class EmployeeController {
	@Autowired
	private EmployeeServiceImpl eservice;
	
	@Value("${app.name}")
	private String appName;
	@Value("{app.version}")
	private String version;
	@GetMapping("/")
	public String Welcome() {
		return "Welcome to Swagger ui";
	}
	
	
	@GetMapping("/appdetails")
	public String getAppdetails()
	{
		return "App Name="+appName;
	}
	//handler method
	@GetMapping("/employees")
	public List<Employee>getEmployees()
	{
		return eservice.getEmployees();
	}
	// geting employee with employee id
	//url like: localhost:8080/employee/09  
	@GetMapping(value="/employee/{id}",produces = "application/json")
	public Employee getEmployee(@PathVariable("id")int id)
	{
		return eservice.getEmployee(id);
	}
	//request param
	//localhost:8080/employee?id=23
	@DeleteMapping("/employee")
	public void deleteEmployee(@RequestParam int id)
	{
		eservice.deleteEmpByid(id);
	}
	@PostMapping("/employees")
	public Employee saveEmployees(@RequestBody Employee employee)
	{
		return eservice.saveEmployee(employee)  ;
		
		
	}
	@PutMapping("/employees/{id}")
	public Employee updateEmployee(@PathVariable int id,@RequestBody Employee employee)
	{
		employee.setId(id );
		return  eservice.saveEmployee(employee);
	}

}
