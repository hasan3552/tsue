package com.company.service;

import com.company.config.CustomUserDetails;
import com.company.dto.AuthDTO;
import com.company.dto.CategoryCreateDTO;
import com.company.dto.MenuDTO;
import com.company.dto.ProfileDTO;
import com.company.entity.CategoryEntity;
import com.company.entity.MenuEntity;
import com.company.entity.ProfileEntity;
import com.company.exps.ItemNotFoundExseption;
import com.company.repository.CategoryRepository;
import com.company.repository.MenuRepository;
import com.company.repository.ProfileRepository;
import com.company.util.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryService {

private final CategoryRepository categoryRepository;
private  final MenuRepository menuRepository;

    public String create(CategoryCreateDTO dto) {
        Optional<MenuEntity> byId = menuRepository.findById(dto.getMenuId());
        if (byId.isEmpty()) {
            throw new ItemNotFoundExseption("menu not found");
        }


        CategoryEntity entity = new CategoryEntity();

        entity.setName(dto.getName());
        entity.setMenuId(dto.getMenuId());

        categoryRepository.save(entity);
        return "successfully create";
    }

    public String update(CategoryCreateDTO dto, String id) {

        Optional<MenuEntity> byId = menuRepository.findById(dto.getMenuId());
        if (byId.isEmpty()) {
            throw new ItemNotFoundExseption("menu not found");
        }


        Optional<CategoryEntity> optional = categoryRepository.findById(id);
        if(optional.isEmpty()){
            throw new ItemNotFoundExseption("item not found");
        }
        CategoryEntity entity = optional.get();

        entity.setName(dto.getName());
        categoryRepository.save(entity);
        return "successfully updated";
    }


}
