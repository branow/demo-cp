package com.brano.democp.service.impl;

import com.brano.democp.entity.User;
import com.brano.democp.entity.VerificationToken;
import com.brano.democp.exception.ExpirationTimeException;
import com.brano.democp.model.UserModel;
import com.brano.democp.repository.UserRepository;
import com.brano.democp.service.UserService;
import com.brano.democp.service.VerificationTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final VerificationTokenService verificationTokenService;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, VerificationTokenService verificationTokenService, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.verificationTokenService = verificationTokenService;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User register(UserModel userModel) {
        User user = mapToUser(userModel);
        return userRepository.save(user);
    }

    @Override
    public User enableUser(String token) throws ExpirationTimeException {
        VerificationToken verificationToken = verificationTokenService.findByToken(token);
        verificationTokenService.delete(verificationToken);
        if (verificationToken.getExpirationTime().isBefore(LocalDateTime.now())) {
            throw new ExpirationTimeException("Expiration time was finished");
        }
        User user = verificationToken.getUser();
        user.setEnable(true);
        User userSaved = userRepository.save(user);
        return userSaved;
    }


    private User mapToUser(UserModel userModel) {
        return User.builder()
                .userName(userModel.getName())
                .email(userModel.getEmail())
                .password(passwordEncoder.encode(userModel.getPassword()))
                .build();
    }

}
