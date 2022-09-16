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

    @Column(name = "email")
    private String email;

    @Column(name = "birthday")
    private LocalDate birthday;

    @Column(name = "info")
    private String info;

    @Column(name = "profile_id")
    private Integer profileId;

    @JoinColumn(name = "profile_id", insertable = false, updatable = false, unique = true)
    @OneToOne(fetch = FetchType.LAZY)
    private ProfileEntity profile;

}
