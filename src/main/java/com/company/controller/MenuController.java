package com.company.controller;

import com.company.dto.AuthDTO;
import com.company.dto.MenuDTO;
import com.company.dto.ProfileDTO;
import com.company.service.AuthService;
import com.company.service.MenuService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RequestMapping("/menu")
@RestController
@RequiredArgsConstructor
public class MenuController {

    private final MenuService menuService;

    @PostMapping()
    public ResponseEntity<String> create(@RequestBody MenuDTO dto) {

        String response = menuService.create(dto);
        return ResponseEntity.ok().body(response);
    }
    @PutMapping("/{id}")
    public ResponseEntity<String> update(@PathVariable("id") Integer id ,@RequestBody MenuDTO dto) {

        String response = menuService.update(dto,id);
        return ResponseEntity.ok().body(response);
    }


}
