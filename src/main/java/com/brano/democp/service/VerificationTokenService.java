package com.brano.democp.service;

import com.brano.democp.entity.User;
import com.brano.democp.entity.VerificationToken;
import org.springframework.stereotype.Service;

@Service
public interface VerificationTokenService {
    VerificationToken createToken(User user);

    VerificationToken findByToken(String token);

    void delete(VerificationToken token);

    void deleteById(Long id);
}
