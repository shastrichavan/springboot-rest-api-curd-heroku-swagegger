package com.shastri.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;

@Data
@Entity
@Table(name="tbl_employees")
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name="name")
	private String name;

	@Column(name="age")
	private int age;

	@Column(name="location")
	private String location;

	@Column(name="email")
	private String email;

	@Column(name="department")
	private String department;
	@CreationTimestamp
	@Column(name="created_at", nullable=false ,updatable=false)
	private Date createdat;
	@UpdateTimestamp
	@Column(name="updated_at")
	private Date updatedat;
}
