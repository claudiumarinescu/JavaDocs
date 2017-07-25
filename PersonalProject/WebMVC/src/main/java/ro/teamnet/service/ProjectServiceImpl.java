package ro.teamnet.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ro.teamnet.dao.interfaces.ProjectRepository;
import ro.teamnet.dao.interfaces.TaskRepository;
import ro.teamnet.model.Project;
import ro.teamnet.model.Task;
import ro.teamnet.service.interfaces.ProjectService;

import java.util.List;

@Service
@Transactional
public class ProjectServiceImpl implements ProjectService {

    private ProjectRepository projectRepository;
    private TaskRepository taskRepository;

    @Autowired
    public ProjectServiceImpl(ProjectRepository projectRepository, TaskRepository taskRepository) {
        this.projectRepository = projectRepository;
        this.taskRepository = taskRepository;
    }

    public List<Project> listAllProjects() {
        return projectRepository.listAllProjects();
    }

    public void saveOrUpdate(Project project) {
        projectRepository.saveOrUpdate(project);
    }

    public Project findProjectById(Long id) {
        return projectRepository.findProjectById(id);
    }

    public void deleteProject(Long id) {
        projectRepository.deleteProject(id);
    }

    public List<Task> listAllTasks() {
        return taskRepository.listAllTasks();
    }

}
