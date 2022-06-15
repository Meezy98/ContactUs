package com.personal.contact.repository;

import com.personal.contact.entity.models.ReasonLookup;
import com.personal.contact.entity.models.Submission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubmissionJPA extends JpaRepository<Submission, Integer> {
    public Submission findByReason(ReasonLookup reason);
}
