package com.trading.service;



import com.trading.dto.UserRequest;
import com.trading.entity.User;
import com.trading.exception.BadRequestException;
import com.trading.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {

    private final UserRepository userRepository;

    public User registerUser(UserRequest request) {
        log.info("Registering user with email: {}", request.getEmail());

        if (userRepository.findByEmail(request.getEmail()).isPresent()) {
            throw new BadRequestException("Email already exists");
        }

        User user = User.builder()
                .name(request.getName())
                .email(request.getEmail())
                .balance(request.getBalance())
                .build();

        return userRepository.save(user);
    }

    public List<User> getAllUsers() {
        log.info("Fetching all users");
        return userRepository.findAll();
    }
}
