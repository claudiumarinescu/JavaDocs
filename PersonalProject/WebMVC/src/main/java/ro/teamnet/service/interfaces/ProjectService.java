package ro.teamnet.service.interfaces;


import ro.teamnet.model.Project;
import ro.teamnet.model.Task;

import java.util.List;

public interface ProjectService {

    List<Project> listAllProjects();

    void saveOrUpdate(Project project);

    Project findProjectById(Long id);

    void deleteProject(Long id);

    List<Task> listAllTasks();
}
