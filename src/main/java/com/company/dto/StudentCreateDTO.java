package com.company.dto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import java.time.LocalDate;

@Getter
@Setter
public class StudentCreateDTO {

    private String course;
    private LocalDate birthday;
    private LocalDate enterDay;
    private String username;
    private String password;
    private String name;
    private String surname;
    private String middleName;
    private String attachId;

}
