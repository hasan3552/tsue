package com.company.dto;

import com.company.enums.ProfileRole;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProfileDTO {


    private Integer id;

    private  String  name;
    private String surname;
    private String username;
    private String course;
    private ProfileRole role;
    private String password;
    private String jwt;




}
