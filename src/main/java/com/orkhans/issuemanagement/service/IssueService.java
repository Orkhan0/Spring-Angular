package com.orkhans.issuemanagement.service;

import com.orkhans.issuemanagement.dto.IssueDto;
import com.orkhans.issuemanagement.util.TPage;
import lombok.Data;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IssueService {

    IssueDto save(IssueDto issue);

    IssueDto getById(Long id);

    TPage<IssueDto> getAllPageable(Pageable pageable);

    Boolean delete(IssueDto issue);

}
