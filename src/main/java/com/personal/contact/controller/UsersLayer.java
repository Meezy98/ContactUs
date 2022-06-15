package com.personal.contact.controller;

import com.personal.contact.entity.models.Users;
import com.personal.contact.entity.models.dto.UsersDTO;
import com.personal.contact.service.UserService;
import com.personal.contact.service.implementations.UserServiceImpl;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Stream;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping(name = "/users")
public class UsersLayer {
    private final UserService userService;

    @GetMapping(name = "/all")
    public ResponseEntity<List<Users>>getAllUsers(){
        return ResponseEntity.ok().body(userService.getUsers());

    }
    @PostMapping("/role/save")
    public ResponseEntity<?>roleToUser(@RequestBody RoleToUserForm form){
        userService.roleToUser(form.getUsername(), form.getRoleName());
        return ResponseEntity.ok().build();
    }
}
@Data
class RoleToUserForm{
    private String username;
    private String roleName;
}