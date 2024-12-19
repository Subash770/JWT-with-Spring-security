package com.project.auth_api.service;

import com.project.auth_api.dto.LoginUserDto;
import com.project.auth_api.dto.RegisterUserDto;
import com.project.auth_api.entity.User;
import com.project.auth_api.repository.UserRepository;
import com.project.auth_api.entity.Role;
import com.project.auth_api.entity.RoleEnum;
import com.project.auth_api.repository.RoleRepository;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Optional;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
    private final UserRepository userRepository;
    
    private final RoleRepository roleRepository;
    
    private final PasswordEncoder passwordEncoder;
    
    private final AuthenticationManager authenticationManager;

    public AuthenticationService(
            UserRepository userRepository,
            RoleRepository roleRepository,
            AuthenticationManager authenticationManager,
            PasswordEncoder passwordEncoder
        ) {
            this.userRepository = userRepository;
            this.roleRepository = roleRepository;
            this.authenticationManager = authenticationManager;
            this.passwordEncoder = passwordEncoder;
        }

    public User signup(RegisterUserDto input) {
        Optional<Role> optionalRole = roleRepository.findByName(RoleEnum.USER);
            
        if (optionalRole.isEmpty()) {
            return null;
        }
            
        var user = new User()
            .setFullName(input.getFullName())
            .setEmail(input.getEmail())
            .setPassword(passwordEncoder.encode(input.getPassword()))
            .setRole(optionalRole.get());

        return userRepository.save(user);
    }

    public User authenticate(LoginUserDto input) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        input.getEmail(),
                        input.getPassword()
                )
        );

        return userRepository.findByEmail(input.getEmail())
                .orElseThrow();
    }
}