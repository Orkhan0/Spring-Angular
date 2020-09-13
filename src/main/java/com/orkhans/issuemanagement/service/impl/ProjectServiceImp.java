package com.orkhans.issuemanagement.service.impl;

import com.orkhans.issuemanagement.dto.ProjectDto;
import com.orkhans.issuemanagement.entity.Project;
import com.orkhans.issuemanagement.repository.ProjectRepository;
import com.orkhans.issuemanagement.service.ProjectService;
import com.orkhans.issuemanagement.util.TPage;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.Arrays;
import java.util.List;

@Service
public class ProjectServiceImp implements ProjectService {

    private final ProjectRepository projectRepository;
    private final ModelMapper modelMapper;

    public ProjectServiceImp(ProjectRepository projectRepository, ModelMapper modelMapper) {
        this.projectRepository = projectRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public ProjectDto save(ProjectDto project) {
        Project projectCkeck = projectRepository.getByProjectCode(project.getProjectCode());

        if (projectCkeck != null)
            throw new IllegalArgumentException("Project code already exist");

        Project p = modelMapper.map(project, Project.class);
        p = projectRepository.save(p);
        project.setId(p.getId());
        return project;
    }

    @Override
    public ProjectDto getById(Long id) {
        Project p = projectRepository.getOne(id);
        return modelMapper.map(p, ProjectDto.class);
    }

    @Override
    public Project getByProjectCode(String projectCode) {
//        return projectRepository.getByProjectCode(projectCode);
        return null;
    }

    @Override
    public List<Project> getByProjectCodeContains(String projectCode) {
//        return projectRepository.getByProjectCodeContains(projectCode);
        return null;
    }

    @Override
    public TPage<ProjectDto> getAllPageable(Pageable pageable) {
        Page<Project> data = projectRepository.findAll(pageable);
        TPage<ProjectDto> response = new TPage<>();
        response.setStat(data, Arrays.asList(modelMapper.map(data.getContent(), ProjectDto[].class)));
        return response;
    }

    @Override
    public Boolean delete(Project project) {
        return null;
    }

    public Boolean delete(Long id) {
        projectRepository.deleteById(id);
        return true;
    }

    @Override
    public ProjectDto update(Long id, ProjectDto project) {
        Project projectDB = projectRepository.getOne(id);
        if (projectDB == null)
            throw new IllegalArgumentException("Project Does Not Exist ID:" + id);

        Project projectCkeck = projectRepository.getByProjectCodeAndIdNot(project.getProjectCode(), id);
        if (projectCkeck != null)
            throw new IllegalArgumentException("Project code already exist");

        projectDB.setProjectCode(project.getProjectCode());
        projectDB.setProjectName(project.getProjectName());

        projectRepository.save(projectDB);
        return modelMapper.map(projectDB, ProjectDto.class);
    }
}
