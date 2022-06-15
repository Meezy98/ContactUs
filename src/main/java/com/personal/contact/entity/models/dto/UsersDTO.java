package com.personal.contact.entity.models.dto;

import com.personal.contact.entity.models.Roles;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import java.util.Collection;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UsersDTO {
    String username;
    String name;
    String email;
    @ManyToOne(fetch = FetchType.EAGER)
    Collection<Roles> roles;
}
