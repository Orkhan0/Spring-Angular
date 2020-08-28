package com.orkhans.issuemanagement.service.impl;

import com.orkhans.issuemanagement.dto.IssueDto;
import com.orkhans.issuemanagement.entity.Issue;
import com.orkhans.issuemanagement.repository.IssueRepository;
import com.orkhans.issuemanagement.service.IssueService;
import com.orkhans.issuemanagement.util.TPage;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.Arrays;

@Service
public class IssueServiceImpl implements IssueService {

    private final IssueRepository issueRepository;
    private final ModelMapper modelMapper;

    public IssueServiceImpl(IssueRepository issueRepository, ModelMapper modelMapper) {
        this.issueRepository = issueRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public IssueDto save(IssueDto issue) {
        if (issue.getDate() == null)
            throw new IllegalArgumentException("Issue Date cannot be null");

        Issue issueDB = modelMapper.map(issue, Issue.class);

        issueDB = issueRepository.save(issueDB);
        return modelMapper.map(issueDB, IssueDto.class);
    }

    @Override
    public IssueDto getById(Long id) {
        Issue issueDB = issueRepository.getOne(id);
        return modelMapper.map(issueDB, IssueDto.class);
    }

    @Override
    public TPage<IssueDto> getAllPageable(Pageable pageable) {
       Page<Issue> data = issueRepository.findAll(pageable);
       TPage page = new TPage<IssueDto>();
       IssueDto[] dtos = modelMapper.map(data.getContent(), IssueDto[].class);
       page.setStat(data, Arrays.asList(dtos));
       return page;
    }

    @Override
    public Boolean delete(IssueDto issue) {
        return null;
    }
}
