package com.io.swagger.SwaggerDocumentation.Service;

import com.io.swagger.SwaggerDocumentation.form.EmployeeForm;
import com.io.swagger.SwaggerDocumentation.model.Employee;
import com.io.swagger.SwaggerDocumentation.respository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements  EmployeeService{

    @Autowired
    EmployeeRepository employeeRepository;
    @Override
    public Employee saveEmployees(EmployeeForm eForm) {
        Employee e = new Employee();
        e.setEmployeeemail(eForm.getEmpEmail());
        e.setEmployeeid(eForm.getEmpNo());
        e.setEmployeename(eForm.getEmpName());
        e.setJoiningDate(eForm.getJoiningDate());
        employeeRepository.save(e);
        return e;
    }

    @Override
    public Employee getEmpDetails(int employeeId) {
        return employeeRepository.findByEmployeeid(employeeId);
    }
}
