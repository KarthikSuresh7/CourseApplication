package com.io.swagger.SwaggerDocumentation.Service;

import com.io.swagger.SwaggerDocumentation.form.EmployeeForm;
import com.io.swagger.SwaggerDocumentation.model.Employee;
import org.springframework.stereotype.Service;

@Service
public interface EmployeeService {

    public Employee saveEmployees(EmployeeForm eForm);

    Employee getEmpDetails(int employeeId);
}
