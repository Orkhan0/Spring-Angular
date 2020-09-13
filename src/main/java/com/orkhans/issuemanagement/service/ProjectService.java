package com.orkhans.issuemanagement.service;

import com.orkhans.issuemanagement.dto.ProjectDto;
import com.orkhans.issuemanagement.entity.Project;
import com.orkhans.issuemanagement.util.TPage;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProjectService {

    ProjectDto save(ProjectDto project);

    ProjectDto getById(Long id);

    Project getByProjectCode(String projectCode);

    List<Project> getByProjectCodeContains(String projectCode);

    TPage<ProjectDto> getAllPageable(Pageable pageable);

    Boolean delete(Project project);

    ProjectDto update(Long id, ProjectDto project);
}
