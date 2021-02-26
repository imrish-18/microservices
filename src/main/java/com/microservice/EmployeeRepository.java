package com.microservice;

import org.springframework.data.couchbase.core.query.ViewIndexed;
import org.springframework.data.couchbase.repository.ReactiveCouchbaseRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
@Repository
@ViewIndexed(designDoc = "employee")
public interface EmployeeRepository extends ReactiveCouchbaseRepository<Employee,String>{

}
