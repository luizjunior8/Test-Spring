package com.ufpb.lcc.jrwalker.controller;

import com.ufpb.lcc.jrwalker.model.User;
import com.ufpb.lcc.jrwalker.request.UserRequest;
import com.ufpb.lcc.jrwalker.response.UserResponse;
import com.ufpb.lcc.jrwalker.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<UserResponse> create(UserRequest dto) {
        User user = this.userService.create(dto.toModel());
        return ResponseEntity.status(HttpStatus.CREATED).body(user.toResponse());
    }
}
