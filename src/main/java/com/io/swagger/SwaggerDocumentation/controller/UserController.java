package com.io.swagger.SwaggerDocumentation.controller;

import com.io.swagger.SwaggerDocumentation.Service.EmployeeService;
import com.io.swagger.SwaggerDocumentation.form.EmployeeForm;
import com.io.swagger.SwaggerDocumentation.model.Employee;
import com.io.swagger.SwaggerDocumentation.respository.EmployeeRepository;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    EmployeeService employeeService;

    @Autowired
    EmployeeRepository employeeRepository;

    @Operation(summary = "Greeting Message")
    @GetMapping("/message")
    public  String getMessage(){
        return "Success!!!";
    }

    @Operation(summary = "Adding the Employees")
    @PostMapping(value = "/addEmployee",produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> saveEmployee(@RequestBody EmployeeForm eForm) {
        Employee employee = null;
        try {


            Employee emp = employeeRepository.getempdetails(eForm.getEmpNo());

            if(Objects.isNull(emp)){
                 employee = employeeService.saveEmployees(eForm);
            }else{
                 employee = employeeService.updateEmployeeDetails(eForm,emp);
            }


           return ResponseEntity.ok(employee) ;
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @Operation(summary = "GetAllEmpDetails")
    @GetMapping("/getEmployeeDetails")
    public ResponseEntity<?>getEmployeeDetails(@RequestParam int employeeId){
        try {
           Employee empDetails =  employeeService.getEmpDetails(employeeId);
           if(empDetails!=null){
               return ResponseEntity.ok(empDetails);
           }else {
               return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Please provide valid EmployeeID");
           }
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @DeleteMapping("/deleteEmployee/{employeeId}")
    public ResponseEntity<?>deleteEmpDetails(@PathVariable Integer employeeId){
        try {
            String message = employeeService.deleteEmpDetails(employeeId);
            if(message.equalsIgnoreCase("Success")){
                return ResponseEntity.ok(message);
            }else {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Data is already deleted ");
            }
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

}
