package com.company.entity;

import com.company.enums.Career;
import com.company.enums.ProfileStatus;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "employee")
public class EmployeeEntity extends User{

    @Column(name = "career")
    @Enumerated(EnumType.STRING)
    private Career career;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "middle_name")
    private String middleName;

//    @Column(name = "age")
//    private Integer age;

    @Column(name = "email")
    private String email;

    @Column(name = "birthday")
    private LocalDate birthday;

    @Column(name = "info")
    private String info;

}
