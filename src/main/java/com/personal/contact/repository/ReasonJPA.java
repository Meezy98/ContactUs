package com.personal.contact.repository;

import com.personal.contact.entity.models.ReasonLookup;
import com.personal.contact.entity.models.dto.SubmissionDTO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReasonJPA extends JpaRepository<ReasonLookup,Integer> {

}
