package com.company.repository;

import com.company.entity.CategoryEntity;
import com.company.entity.MenuEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface MenuRepository extends JpaRepository<MenuEntity, Integer> {

}
