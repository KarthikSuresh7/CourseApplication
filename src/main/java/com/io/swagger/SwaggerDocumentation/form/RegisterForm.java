package com.io.swagger.SwaggerDocumentation.form;

import com.io.swagger.SwaggerDocumentation.model.Role;
import lombok.Data;

@Data
public class RegisterForm {

    private String firstName;

    private String lastName;

    private String username;

    private  String password;

    private Role role;
}
