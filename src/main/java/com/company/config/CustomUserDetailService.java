package com.company.config;


import com.company.entity.ProfileEntity;
import com.company.repository.ProfileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class CustomUserDetailService implements UserDetailsService {

    private final ProfileRepository profileRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<ProfileEntity> entity = profileRepository.findByUsername(username);
        if (entity.isEmpty()) {
            throw new UsernameNotFoundException("User Not Found");
        }
        System.out.println(entity.get());
        return new CustomUserDetails(entity.get());
    }
}
