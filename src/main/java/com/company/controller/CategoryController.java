package com.company.controller;

import com.company.dto.AuthDTO;
import com.company.dto.CategoryCreateDTO;
import com.company.dto.MenuDTO;
import com.company.dto.ProfileDTO;
import com.company.service.AuthService;
import com.company.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RequestMapping("/categoty")
@RestController
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;

    @PostMapping()
    public ResponseEntity<String> create(@RequestBody CategoryCreateDTO dto) {

        String response = categoryService.create(dto);
        return ResponseEntity.ok().body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> update(@PathVariable("id") String id ,@RequestBody CategoryCreateDTO dto) {

        String response = categoryService.update(dto,id);
        return ResponseEntity.ok().body(response);
    }




}
