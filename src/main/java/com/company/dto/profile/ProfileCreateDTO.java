package com.company.dto.profile;

import com.company.enums.ProfileRole;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class ProfileCreateDTO {

    private String username;
    private String password;
    private String name;
    private String surname;
    private String middleName;
    private String course;
    private LocalDate birthday;
    private LocalDate enterDay;
    private ProfileRole role;
    private String photoId;

}
