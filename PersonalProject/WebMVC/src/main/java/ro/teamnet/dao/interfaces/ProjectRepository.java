package ro.teamnet.dao.interfaces;

import ro.teamnet.model.Project;

import java.util.List;


public interface ProjectRepository {

    List<Project> listAllProjects();

    void saveOrUpdate(Project job);

    Project findProjectById(Long id);

    void deleteProject(Long id);

}
