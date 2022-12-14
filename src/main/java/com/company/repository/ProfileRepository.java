package com.company.repository;

import com.company.entity.ProfileEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ProfileRepository extends JpaRepository<ProfileEntity,Integer> {


    Optional<ProfileEntity> findByUsername(String username);
}
