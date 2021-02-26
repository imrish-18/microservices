package com.microservice;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.config.EnableWebFlux;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;
@Configuration
@EnableWebFlux
public class EmployeeRouter {

	  
	  /**
  	 * Get the all emp.
  	 *
  	 * @param showHandler the show handler
  	 * @return the all emp
  	 */
  	@Bean
	  public RouterFunction<ServerResponse> getAllEmp(EmployeeHandler showHandler) {
	    return RouterFunctions
	      .route(RequestPredicates.GET("/getAllEmp"), showHandler::getAllEmp);
	  }
	  
  	/**
  	 * Get the by id.
  	 *
  	 * @param showHandler the show handler
  	 * @return the by id
  	 */
  	@Bean
	  public RouterFunction<ServerResponse> getById(EmployeeHandler showHandler) {
	    return RouterFunctions
	      .route(RequestPredicates.GET("/getById/{id}"), showHandler::getById);
	  }
	
	  /**
  	 * Save emp.
  	 *
  	 * @param handler the handler
  	 * @return the router function
  	 */
  	@Bean
	  public RouterFunction<ServerResponse> saveEmp(EmployeeHandler handler)
	  {
	 return RouterFunctions.route(RequestPredicates.POST("/postdata").
			 and(RequestPredicates.contentType(MediaType.APPLICATION_JSON)), handler::saveEmp);
}
	  
  	/**
  	 * Delete by id.
  	 *
  	 * @param showHandler the show handler
  	 * @return the router function
  	 */
  	@Bean
	  public RouterFunction<ServerResponse> deleteById(EmployeeHandler showHandler) {
	    return RouterFunctions
	      .route(RequestPredicates.DELETE("/deleteById/{id}"), showHandler::deleteById);
	  }  
	  
  	/**
  	 * Update.
  	 *
  	 * @param showHandler the show handler
  	 * @return the router function
  	 */
  	@Bean
	  public RouterFunction<ServerResponse> update(EmployeeHandler showHandler) {
	    return RouterFunctions
	      .route(RequestPredicates.PATCH("/pathcUpdate/{id}"), showHandler::updateEmp);
	  } 

	@Bean
	  public RouterFunction<ServerResponse> updatewithPut(EmployeeHandler showHandler) {
	    return RouterFunctions
	      .route(RequestPredicates.PUT("/update/{id}"), showHandler::updateEmp);
	  } 
@Bean
public RouterFunction<ServerResponse> deleteAll(EmployeeHandler showHandler) {
  return RouterFunctions
    .route(RequestPredicates.DELETE("/deleteAll"), showHandler::deleteAllEmp);
} 
}
    