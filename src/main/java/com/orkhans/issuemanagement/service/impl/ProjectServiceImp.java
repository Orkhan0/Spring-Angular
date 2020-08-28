package com.orkhans.issuemanagement.service.impl;

import com.orkhans.issuemanagement.entity.Project;
import com.orkhans.issuemanagement.repository.ProjectRepository;
import com.orkhans.issuemanagement.service.ProjectService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProjectServiceImp implements ProjectService {

    private final ProjectRepository projectRepository;

    public ProjectServiceImp(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @Override
    public Project save(Project project) {
        if (project.getProjectCode() == null) {
            throw new IllegalArgumentException("Project code cannot be null");
        }
        return projectRepository.save(project);
    }

    @Override
    public Project getById(Long id) {
        return projectRepository.getOne(id);
    }

    @Override
    public List<Project> getByProjectCode(String projectCode) {
//        return projectRepository.getByProjectCode(projectCode);
        return null;
    }

    @Override
    public List<Project> getByProjectCodeContains(String projectCode) {
//        return projectRepository.getByProjectCodeContains(projectCode);
        return null;
    }

    @Override
    public Page<Project> getAllPageable(Pageable pageable) {
        return projectRepository.findAll(pageable);
    }

    @Override
    public Boolean delete(Project project) {
        return null;
    }
}
