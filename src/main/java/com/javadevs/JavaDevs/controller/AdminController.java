package com.javadevs.JavaDevs.controller;

import com.javadevs.JavaDevs.entity.Actor;
import com.javadevs.JavaDevs.entity.User;
import com.javadevs.JavaDevs.exception.ExpiredTokenException;
import com.javadevs.JavaDevs.exception.InvalidTokenException;
import com.javadevs.JavaDevs.service.ActorService;
import com.javadevs.JavaDevs.service.AdminService;
import com.javadevs.JavaDevs.service.TokenService;
import com.javadevs.JavaDevs.service.UserAuthenticationService;
import io.jsonwebtoken.Claims;
import org.apache.tomcat.util.http.parser.Authorization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    private final AdminService adminService;
    private final ActorService actorService;
    private final UserAuthenticationService userAuthenticationService;
    private final TokenService tokenService;

    @Autowired
    public AdminController(AdminService adminService, ActorService actorService, UserAuthenticationService userAuthenticationService, TokenService tokenService) {
        this.adminService = adminService;
        this.actorService = actorService;
        this.userAuthenticationService = userAuthenticationService;
        this.tokenService = tokenService;
    }

    @GetMapping("/teste")
    public Integer getActorById(@RequestAttribute("idUser") Integer actorId) {
        return actorId;
    }

    @GetMapping("/actors")
    public ResponseEntity<List<Actor>> getAllActor(@RequestAttribute("idUser") Integer actorId) {
        return ResponseEntity.ok(actorService.getAllActor());
    }
}
