package com.personal.contact.entity.models;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.Collection;

@Data
@Entity
@AllArgsConstructor
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Submission {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    String submissionId;
    @OneToOne
    @JoinColumn(name = "username")
    Users users;
    String name;
    @OneToOne
    @JoinColumn(name = "email")
    Users userEntity;
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "reason")
    ReasonLookup reason;
    String details;


}
