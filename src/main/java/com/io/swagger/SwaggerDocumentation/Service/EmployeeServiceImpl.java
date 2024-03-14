package com.io.swagger.SwaggerDocumentation.Service;

import com.io.swagger.SwaggerDocumentation.form.EmployeeForm;
import com.io.swagger.SwaggerDocumentation.model.Employee;
import com.io.swagger.SwaggerDocumentation.respository.EmployeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
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
        log.info("Employee saved successfully");
        return e;
    }

    @Override
    public Employee getEmpDetails(int employeeId) {
        return employeeRepository.findByEmployeeid(employeeId);
    }
}
