package com.microservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import reactor.core.publisher.Mono;

/**
 * The Class EmployeeHandler.
 */
@Component
public class EmployeeHandler {

	
	/** The emp. */
	@Autowired
	private EmployeeService emp;

  public Mono<ServerResponse> getAllEmp(ServerRequest serverRequest) {
	   
	    return ServerResponse.ok().body(emp.getAll(), Employee.class);
	  }
  
  /**
   * Get the by id.
   *
   * @param serverRequest the server request
   * @return the by id
   */
  public Mono<ServerResponse> getById(ServerRequest serverRequest) {
	   
	  String id=serverRequest.pathVariable("id");
	    return ServerResponse.ok().body(emp.getById(id), Employee.class);
	  }
  
  /**
   * Save emp.
   *
   * @param serverRequest the server request
   * @return the mono
   */
  public Mono<ServerResponse> saveEmp(ServerRequest serverRequest) {
	  
	   return serverRequest.bodyToMono(Employee.class).flatMap(res->{
		   return ServerResponse.ok().
				   contentType(MediaType.APPLICATION_JSON).body(emp.saveEmp(res), Employee.class);
	   });
	    
	  }
  
  /**
   * Delete.
   *
   * @param serverRequest the server request
   * @return the mono
   */
  public Mono<ServerResponse> deleteById(ServerRequest serverRequest) {
	String id=serverRequest.pathVariable("id");
	    return ServerResponse.ok().body(emp.delete(id),Void.class);
	  }
  
  
  /**
   * Update emp.
   *
   * @param serverRequest the server request
   * @return the mono
   */
  public Mono<ServerResponse> updateEmp(ServerRequest serverRequest) {
	  
	  String id=serverRequest.pathVariable("id");
	  
	  return serverRequest.bodyToMono(Employee.class).flatMap(res->{
		  return ServerResponse.ok().body(emp.update(id,res),Employee.class);
	  });

	  }
  
  public Mono<ServerResponse> deleteAllEmp(ServerRequest serverRequest){
	  
	  return ServerResponse.ok().body(emp.deleteAll(),Void.class);
  }
	
}
