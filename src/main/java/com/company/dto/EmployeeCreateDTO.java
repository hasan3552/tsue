package com.company.dto;

import com.company.enums.Career;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Getter
@Setter
public class EmployeeCreateDTO {

    @NotNull
    private Career career;
    @NotBlank
    private String phoneNumber;
    @NotBlank
    private String name;
    @NotBlank
    private String surname;
    @NotBlank
    private String middleName;

    @Email(message = "Email should be valid", regexp = "[a-zA-Z]+[0-9]+@[a-z]+\\.[a-zA-Z]+")
    private String email;
    @NotNull
    private LocalDate birthday;
    @NotNull
    private String info;
    private String attachId;

    @NotBlank
    private String username;
    @NotBlank
    private String password;


}
