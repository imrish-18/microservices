package com.microservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * The Class EmployeeService.
 */
@Service
public class EmployeeService {
  
	/** The rep. */
	@Autowired
	private EmployeeRepository rep;
	
  /**
   * Save.
   *
   * @param emp1 the emp 1
   * @return the Mono
   */

	public Mono<Employee> saveEmp(Employee e)
	{
		System.out.println(e);
		return rep.save(e);
	}
  
  /**
   * Get the all.
   *
   * @return the all
   */
  public Flux<Employee> getAll()
  {
	  return rep.findAll();
  }
  
  /**
   * Gets the by id.
   *
   * @param id the id
   * @return the by id
   */
  public Mono<Employee> getById(String id)
  {
	  return rep.findById(id);
  }
  
  /**
   * Update.
   *
   * @param id the id
   * @param emp the emp
   * @return the mono
   */
  public Mono<Employee> update(String id,Employee emp)
  {

	  return rep.findById(id).map(res->{
	res.setCompany(emp.getCompany());
	res.setName(emp.getName());
	return res;
}).
	flatMap(res->
			  {
				return rep.save(res) ; 
			  });

  }
  
  /**
   * Delete.
   *
   * @param id the id
   * @return the mono
   */
  public Mono<Void> delete(String id)
  {
	  return rep.deleteById(id);
//	return  rep.findById(id).map(Employee::getId).flatMap(obj->{
//		
//		  return rep.deleteById(obj);
//	  });
	  
  }
  
  public Mono<Void> deleteAll()
  {
	  return rep.deleteAll();
  }
}
