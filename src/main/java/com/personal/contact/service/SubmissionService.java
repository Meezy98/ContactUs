package com.personal.contact.service;

import com.personal.contact.entity.models.Submission;
import com.personal.contact.entity.models.dto.SubmissionDTO;

public interface SubmissionService {
    public SubmissionDTO entityToDTO(Submission submission);
    public void formSubmission(SubmissionDTO submissionDTO);
    public SubmissionDTO findBySubmissionId(String submissionId);
    }


