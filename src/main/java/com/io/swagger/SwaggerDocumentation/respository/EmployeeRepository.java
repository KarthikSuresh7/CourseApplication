package com.io.swagger.SwaggerDocumentation.respository;

import com.io.swagger.SwaggerDocumentation.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
    Employee findByEmployeeid(int employeeId);


    @Query("from Employee where employeeid=:empNo")
    Employee getempdetails(int empNo);
}
