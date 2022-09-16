package com.company.service;

import com.company.dto.EmployeeCreateDTO;
import com.company.dto.ResponseDTO;
import com.company.dto.StudentCreateDTO;
import com.company.dto.profile.ProfileCreateDTO;
import com.company.entity.EmployeeEntity;
import com.company.entity.ProfileEntity;
import com.company.entity.StudentEntity;
import com.company.enums.ProfileRole;
import com.company.enums.ProfileStatus;
import com.company.exp.BadRequestException;
import com.company.exp.ItemNotFoundException;
import com.company.repository.ProfileRepository;
import com.company.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class ProfileService {
    @Autowired
    private ProfileRepository profileRepository;

    @Autowired
    @Lazy
    private AttachService attachService;

    @Value("${server.url}")
    private String serverUrl;

    public ProfileEntity get(Integer id) {
        return profileRepository.findById(id).orElseThrow(() -> {
            throw new ItemNotFoundException("Profile Not found");
        });
    }

    public ProfileEntity create(ProfileCreateDTO dto) {

        ProfileEntity profile = getByUsername(dto.getUsername());

        if (profile != null){
            throw new BadRequestException("This user already exist");
        }

        ProfileEntity entity = new ProfileEntity();
        entity.setVisible(true);
        entity.setStatus(ProfileStatus.ACTIVE);
        entity.setPassword(MD5Util.getMd5(dto.getPassword()));
        entity.setCreatedDate(LocalDateTime.now());
        entity.setRole(dto.getRole());
        entity.setUsername(dto.getUsername());
        entity.setMiddleName(dto.getMiddleName());
        entity.setName(dto.getName());
        entity.setSurname(dto.getSurname());
        entity.setPhotoId(dto.getPhotoId());

        profileRepository.save(entity);

        return entity;
    }
    public ProfileEntity createByEmp(EmployeeCreateDTO dto) {

        ProfileCreateDTO profile = new ProfileCreateDTO();
        profile.setName(dto.getName());
        profile.setSurname(dto.getSurname());
        profile.setMiddleName(dto.getMiddleName());
        profile.setPassword(dto.getPassword());
        profile.setRole(ProfileRole.ROLE_MODERATOR);
        profile.setUsername(dto.getUsername());
        profile.setPhotoId(dto.getAttachId());

        return create(profile);
      }

    private ProfileEntity getByUsername(String username) {

        Optional<ProfileEntity> optional = profileRepository.findByUsername(username);
        return optional.orElse(null);

    }



    public ProfileEntity createStudent(StudentCreateDTO dto) {

        ProfileCreateDTO profile = new ProfileCreateDTO();
        profile.setName(dto.getName());
        profile.setSurname(dto.getSurname());
        profile.setMiddleName(dto.getMiddleName());
        profile.setPassword(dto.getPassword());
        profile.setRole(ProfileRole.ROLE_USER);
        profile.setUsername(dto.getUsername());
        profile.setPhotoId(dto.getAttachId());

        return create(profile);

    }
}