package com.orkhans.issuemanagement.repository;

import com.orkhans.issuemanagement.entity.Issue;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IssueRepository extends JpaRepository<Issue, Long> {
    
}
