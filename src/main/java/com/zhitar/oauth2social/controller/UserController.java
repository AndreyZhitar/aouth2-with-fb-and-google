package com.zhitar.oauth2social.controller;

import com.zhitar.oauth2social.exception.ResourceNotFoundException;
import com.zhitar.oauth2social.model.User;
import com.zhitar.oauth2social.security.CurrentUser;
import com.zhitar.oauth2social.security.UserPrincipal;
import com.zhitar.oauth2social.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/user/me")
    @PreAuthorize("hasRole('USER')")
    public User getCurrentUser(@CurrentUser UserPrincipal userPrincipal) {
        User user = userService.findById(userPrincipal.getId());
        if (user == null) {
            throw new ResourceNotFoundException("User", "id", userPrincipal.getId());
        }
        return user;
    }
}
