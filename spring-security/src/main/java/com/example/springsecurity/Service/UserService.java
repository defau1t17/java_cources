package com.example.springsecurity.Service;

import com.example.springsecurity.Entity.Role;
import com.example.springsecurity.Entity.User;
import com.example.springsecurity.Repository.userRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    private userRepository userRepository;

    private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(10);

    public void registration(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.getRoleSet().add(Role.USER);
        userRepository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> byUsername = userRepository.findByUsername(username);
        if ((byUsername.isPresent())){
            return byUsername.get();
        }
        return null;
    }
}
