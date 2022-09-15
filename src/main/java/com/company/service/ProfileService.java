package com.company.service;

import com.company.dto.ResponseDTO;
import com.company.dto.profile.ProfileCreateDTO;
import com.company.entity.ProfileEntity;
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

    public ResponseDTO create(ProfileCreateDTO dto) {

        ProfileEntity profile = getByUsername(dto.getUsername());

        if (profile != null){
            return new ResponseDTO(-1,"This user already exist");
        }

        ProfileEntity entity = new ProfileEntity();
        entity.setVisible(true);
        entity.setStatus(ProfileStatus.ACTIVE);
        entity.setPassword(MD5Util.getMd5(dto.getPassword()));
        entity.setCreatedDate(LocalDateTime.now());
        entity.setRole(dto.getRole());
        entity.setUsername(dto.getUsername());
        entity.setBirthday(dto.getBirthday());
        entity.setCourse(dto.getCourse());
        entity.setEnterDay(dto.getEnterDay());
        entity.setMiddleName(dto.getMiddleName());
        entity.setName(dto.getName());
        entity.setSurname(dto.getSurname());
        entity.setPhotoId(dto.getPhotoId());

        return new ResponseDTO(1,"successfully registration");
    }

    private ProfileEntity getByUsername(String username) {

        Optional<ProfileEntity> optional = profileRepository.findByUsername(username);

        return optional.orElse(null);
    }
}