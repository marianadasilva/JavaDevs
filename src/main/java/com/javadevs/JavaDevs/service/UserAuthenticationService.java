package com.javadevs.JavaDevs.service;

import com.javadevs.JavaDevs.entity.User;
import com.javadevs.JavaDevs.exception.ExistingEmailException;
import com.javadevs.JavaDevs.exception.ExpiredTokenException;
import com.javadevs.JavaDevs.exception.InvalidLoginException;
import com.javadevs.JavaDevs.exception.InvalidTokenException;
import com.javadevs.JavaDevs.repository.UserRepository;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UserAuthenticationService {

    private final UserRepository userRepository;
    private final TokenService tokenService;

    @Autowired
    public UserAuthenticationService(UserRepository userRepository, TokenService tokenService) {
        this.userRepository = userRepository;
        this.tokenService = tokenService;
    }

    public User authenticate(User userData, String token) {
        //User user  = userRepository.findByEmail(dados.getEmail().orElseThrow(ExistingEmailException::new));
        User user  = userRepository.findByEmail(userData.getEmail());
        if (userData.getPassword().equals(user.getPassword()) && !token.isEmpty() && validate(token)) {
            return user;
        } else {
            throw new InvalidLoginException();
        }
    }

    private boolean validate(String token) {
        try {
            String tokenDecoded = token.replace("Bearer ", "");
            Claims claims = tokenService.decodedToken(tokenDecoded);

            if (claims.getExpiration().before(new Date(System.currentTimeMillis()))) throw new ExpiredTokenException();
            return true;
        } catch (ExpiredTokenException et) {
            et.printStackTrace();
            throw et;
        } catch (Exception e) {
            e.printStackTrace();
            throw new InvalidTokenException();
        }

    }
}
