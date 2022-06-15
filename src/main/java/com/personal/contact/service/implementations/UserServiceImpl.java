package com.personal.contact.service.implementations;

import com.personal.contact.entity.models.Roles;
import com.personal.contact.entity.models.Users;
import com.personal.contact.entity.models.dto.UsersDTO;
import com.personal.contact.repository.RolesJPA;
import com.personal.contact.repository.UsersJPA;
import com.personal.contact.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Slf4j
@RequiredArgsConstructor
@Service @Transactional
public class UserServiceImpl implements UserService, UserDetailsService {
private final UsersJPA usersJPA;
private final RolesJPA rolesJPA;
private final PasswordEncoder passwordEncoder;

    @Override
    public UsersDTO entityToDTO(Users user) {
        UsersDTO usersDTO = new UsersDTO();
        usersDTO.setName(user.getName());
        usersDTO.setUsername(user.getUsername());
        return usersDTO;
    }

    @Override
    public Users saveUser(Users user) {
        log.info("Saving new user {} to the database", user.getName());

        user.setPassword(this.passwordEncoder.encode(user.getPassword()));
        return usersJPA.save(user);
    }

    @Override
    public Roles saveNewRole(Roles role) {
        log.info("Adding new role: {} to list of roles", role.getRoleName());

        return rolesJPA.save(role);
    }

    @Override
    public void roleToUser(String username, String roleName) {
        Users users = usersJPA.findByUsername(username);
        Roles roles = rolesJPA.findByRoleName(roleName);
        if (username == null || roleName == null){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }else {
            log.info("Adding role: {} to user: {}", roleName, username);

            users.getRoles().add(roles);
            System.out.println(users.getRoles().toString());


        }
    }

    @Override
    public List<Users> getUsers() {
        return usersJPA.findAll();
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    Users user = usersJPA.findByUsername(username);
    if (user == null){
    log.error("User {} not found in the database", username);
    throw new UsernameNotFoundException(username);
    }
    else {
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        user.getRoles().forEach(role -> {
            authorities.add(new SimpleGrantedAuthority(role.getRoleName()));
        });
        return new User(user.getUsername(),user.getPassword(),authorities);
    }
    }
}
