package com.personal.contact.entity.models.dto;

import com.personal.contact.entity.models.Submission;
import lombok.AccessLevel;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.util.Collection;

@Data
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SubmissionDTO {
  @Id
  @GenericGenerator(name = "submission_id_seq", strategy = "assigned")
    String submissionId;
    String name;
    String email;
    String details;
    Collection<String> reason;
}
