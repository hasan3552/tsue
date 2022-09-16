package com.company.controller;

import com.company.dto.EmployeeCreateDTO;
import com.company.dto.ResponseDTO;
import com.company.dto.profile.ProfileCreateDTO;
import com.company.service.EmployeeService;
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
@Api(value = "Employee Controller")
@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @ApiOperation(value = "student create by mod")
    @PostMapping("/adm")
    public ResponseEntity<?> create(@RequestBody @Valid EmployeeCreateDTO dto) {
        ResponseDTO response = employeeService.createEmp(dto);
        log.info("Request student create by moderator dto:{}", dto);
        return ResponseEntity.ok(response);
    }
}
