package com.io.swagger.SwaggerDocumentation.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "employee")
@Data
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int snumber;

    private String employeename;

    private String employeeemail;

    private int employeeid;

    private LocalDateTime joiningDate;
}
