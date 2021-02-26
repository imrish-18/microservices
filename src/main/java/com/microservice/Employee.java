package com.microservice;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.couchbase.core.mapping.Document;
import org.springframework.data.couchbase.core.mapping.id.GeneratedValue;
import org.springframework.data.couchbase.core.mapping.id.GenerationStrategy;

/**
 * The Class Employee.
 */
@Document
public class Employee implements Serializable{

/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

/** The id. */
@Id
@GeneratedValue(strategy = GenerationStrategy.UNIQUE)
	private String id;
	
	/** The name. */
	private String name;
	
	/** The company. */
	private String company;
	
	/**
	 * Get the id.
	 *
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getCompany() {
		return company;
	}
	
	public void setCompany(String company) {
		this.company = company;
	}
	
	public Employee(String id, String name, String company) {
		super();
		this.id = id;
		this.name = name;
		this.company = company;
	}
	
	/**
	 * Instantiates a new employee.
	 */
	public Employee()
	{
		
	}
}
