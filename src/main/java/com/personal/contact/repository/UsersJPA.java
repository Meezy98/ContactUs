package com.personal.contact.repository;

import com.personal.contact.entity.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersJPA extends JpaRepository<Users,Integer> {
    public Users findByUsername(String username);

}
