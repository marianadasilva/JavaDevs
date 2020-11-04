package com.javadevs.JavaDevs.service;

import com.javadevs.JavaDevs.entity.Actor;
import com.javadevs.JavaDevs.entity.Admin;
import com.javadevs.JavaDevs.entity.User;
import com.javadevs.JavaDevs.exception.ExistingEmailException;
import com.javadevs.JavaDevs.exception.InvalidLoginException;
import com.javadevs.JavaDevs.repository.ActorRepository;
import com.javadevs.JavaDevs.repository.AdminRepository;
import com.javadevs.JavaDevs.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@Service
public class UserRegistrationService {
    
    private final UserRepository userRepository;
    private final AdminRepository adminRepository;
    private final ActorRepository actorRepository;
    private final TokenService tokenService;
    
    @Autowired
    public UserRegistrationService(UserRepository userRepository, TokenService tokenService,
                                   AdminRepository adminRepository, ActorRepository actorRepository) {
        this.userRepository = userRepository;
        this.tokenService = tokenService;
        this.adminRepository = adminRepository;
        this.actorRepository = actorRepository;
    }

    public boolean verifyUserExists(String email) {
        var userExists = userRepository.findAllUserByEmail(email);
        return userExists.size() > 0;
    }

    public User registerAdmin(User user) {
        if (verifyUserExists(user.getEmail())) throw new ExistingEmailException();

        Admin admin = new Admin();
        adminRepository.save(admin);

        user.setAdmin(admin);
        return userRepository.save(user);
    }

    public User registerActor(User user) {
        if (verifyUserExists(user.getEmail())) throw new ExistingEmailException();

        Actor actor = new Actor();
        actorRepository.save(actor);

        user.setActor(actor);
        return userRepository.save(user);
    }
    
    public User registrate(User user, HttpServletResponse response) {
        User userExists = userRepository.findByEmail(user.getEmail());

        if (userExists.getPassword().equals(user.getPassword())) {
            String token = tokenService.generatetoken(userExists);
            userExists.setToken(token);

            Cookie cookie = new Cookie("token", token);
            cookie.setPath("/");
            cookie.setHttpOnly(true);
            cookie.setMaxAge(60 * 30); // 30 minutos
            response.addCookie(cookie);

            return userExists;
        } else {
            throw new InvalidLoginException();
        }
    }
}
