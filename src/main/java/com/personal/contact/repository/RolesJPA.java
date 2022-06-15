package com.personal.contact.repository;

import com.personal.contact.entity.models.Roles;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.management.relation.Role;

public interface RolesJPA extends JpaRepository<Roles, Long> {
    public Roles findByRoleName(String roleName);
}
