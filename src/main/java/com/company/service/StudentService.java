package com.company.service;

import com.company.dto.ResponseDTO;
import com.company.dto.StudentCreateDTO;
import com.company.dto.profile.ProfileCreateDTO;
import com.company.entity.ProfileEntity;
import com.company.entity.StudentEntity;
import com.company.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private ProfileService profileService;


    public ResponseDTO createStudent(StudentCreateDTO dto) {

        StudentEntity entity = new StudentEntity();
        ProfileEntity profile = profileService.createStudent(dto);

        entity.setProfileId(profile.getId());
        entity.setBirthday(dto.getBirthday());
        entity.setCourse(dto.getCourse());
        entity.setEnterDay(dto.getEnterDay());

        return new ResponseDTO(1,"success");
    }
}
