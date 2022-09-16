package com.company.dto.profile;

import com.company.enums.ProfileRole;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Getter
@Setter
public class ProfileCreateDTO {

    @NotBlank
    private String username;
    @NotBlank
    private String password;
    @NotBlank
    private String name;
    @NotBlank
    private String surname;
    @NotBlank
    private String middleName;
    @NotBlank
    private ProfileRole role;
    private String photoId;

}
