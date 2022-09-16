package com.company.controller;

import com.company.dto.ResponseDTO;
import com.company.dto.StudentCreateDTO;
import com.company.dto.profile.ProfileCreateDTO;
import com.company.service.StudentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;


@Slf4j
@Api(value = "Student Controller")
@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @ApiOperation(value = "student create by mod")
    @PostMapping("/mod")
    public ResponseEntity<?> create(@RequestBody @Valid StudentCreateDTO dto) {
        ResponseDTO response = studentService.createStudent(dto);
        log.info("Request student create by moderator dto:{}", dto);
        return ResponseEntity.ok(response);
    }
}
