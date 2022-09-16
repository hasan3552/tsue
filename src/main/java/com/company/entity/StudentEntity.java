package com.company.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "student")
public class StudentEntity extends User {

    @Column
    private String course;

    @Column(name = "birthday")
    private LocalDate birthday;

    @Column(name = "enter_day")
    private LocalDate enterDay;

    @Column(name = "profile_id")
    private Integer profileId;

    @JoinColumn(name = "profile_id", insertable = false, updatable = false, unique = true)
    @OneToOne(fetch = FetchType.LAZY)
    private ProfileEntity profile;

}
