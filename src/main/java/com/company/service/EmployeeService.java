package com.company.service;

import com.company.dto.EmployeeCreateDTO;
import com.company.dto.ResponseDTO;
import com.company.entity.EmployeeEntity;
import com.company.entity.ProfileEntity;
import com.company.enums.ProfileStatus;
import com.company.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private ProfileService profileService;

    public ResponseDTO createEmp(EmployeeCreateDTO dto) {

        EmployeeEntity entity = new EmployeeEntity();
        ProfileEntity profile = profileService.createByEmp(dto);
        entity.setProfileId(profile.getId());
        entity.setBirthday(dto.getBirthday());
        entity.setCareer(dto.getCareer());
        entity.setEmail(dto.getEmail());
        entity.setInfo(dto.getInfo());
        entity.setCreatedDate(LocalDateTime.now());
        entity.setPhoneNumber(dto.getPhoneNumber());
        entity.setStatus(ProfileStatus.ACTIVE);
        entity.setVisible(true);

        return new ResponseDTO(1,"success");
    }

}
