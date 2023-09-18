package com.brano.democp.service.impl;

import com.brano.democp.entity.User;
import com.brano.democp.entity.VerificationToken;
import com.brano.democp.repository.VerificationTokenRepository;
import com.brano.democp.service.VerificationTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class VerificationTokenServiceImpl implements VerificationTokenService {


    private final VerificationTokenRepository verificationTokenRepository;

    @Autowired
    public VerificationTokenServiceImpl(VerificationTokenRepository verificationTokenRepository) {
        this.verificationTokenRepository = verificationTokenRepository;
    }

    @Override
    public VerificationToken createToken(User user) {
        VerificationToken token = VerificationToken.builder()
                .token(UUID.randomUUID().toString())
                .user(user)
                .build();
        return verificationTokenRepository.save(token);
    }

    @Override
    public VerificationToken findByToken(String token) {
        return verificationTokenRepository.findByToken(token).orElseThrow();
    }

    @Override
    public void delete(VerificationToken token) {
        verificationTokenRepository.delete(token);
    }


    @Override
    public void deleteById(Long tokenId) {
        verificationTokenRepository.deleteById(tokenId);
    }
}
