package com.learn.carbe.service;

import com.learn.carbe.domain.AppUser;
import com.learn.carbe.domain.AppUserRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private final AppUserRepository appUserRepository;

    public UserDetailsServiceImpl(AppUserRepository appUserRepository) {
        this.appUserRepository = appUserRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<AppUser> user = appUserRepository.findByUsername(username);

        User.UserBuilder builder;
        if (user.isPresent()) {
            AppUser currentUser = user.get();
            builder = org.springframework.security.core.userdetails.User.withUsername(currentUser.getUsername());

            builder.password(currentUser.getPassword());
            builder.roles(currentUser.getRole());

        } else {
            throw new UsernameNotFoundException("User not found.");
        }

        return builder.build();
    }
}
