package com.brano.democp.service;

import com.brano.democp.entity.User;
import com.brano.democp.exception.ExpirationTimeException;
import com.brano.democp.model.UserModel;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    User register(UserModel userModel);

    User enableUser(String token) throws ExpirationTimeException;
}
