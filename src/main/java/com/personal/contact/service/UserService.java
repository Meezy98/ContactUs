package com.personal.contact.service;

import com.personal.contact.entity.models.Roles;
import com.personal.contact.entity.models.Users;
import com.personal.contact.entity.models.dto.UsersDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Stream;

public interface UserService {
    public UsersDTO entityToDTO(Users users);
    public Users saveUser(Users users);
    public Roles saveNewRole(Roles role);
    public void roleToUser(String username, String roleName);
    public List<Users> getUsers();
}
