package com.company.service;

import com.company.dto.MenuDTO;
import com.company.entity.MenuEntity;
import com.company.exps.ItemNotFoundExseption;
import com.company.repository.MenuRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MenuService {

    private final MenuRepository menuRepository;


    public String create(MenuDTO dto) {
        MenuEntity entity = new MenuEntity();

        entity.setName(dto.getName());
        menuRepository.save(entity);
        return "successfully create";
    }

    public String update(MenuDTO dto, Integer id) {
        Optional<MenuEntity> optional = menuRepository.findById(id);
        if(optional.isEmpty()){
               throw new ItemNotFoundExseption("item not found");
        }
        MenuEntity entity = optional.get();

        entity.setName(dto.getName());
        menuRepository.save(entity);
        return "successfully updated";
    }
}
