package com.io.swagger.SwaggerDocumentation.form;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class EmployeeForm {

    private String empName;

    private int empNo;

    private String empEmail;

    private LocalDateTime joiningDate;
}
