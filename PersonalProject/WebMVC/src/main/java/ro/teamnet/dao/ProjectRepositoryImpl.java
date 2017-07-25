package ro.teamnet.dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ro.teamnet.dao.interfaces.ProjectRepository;
import ro.teamnet.model.Project;

import java.util.List;

@Repository
public class ProjectRepositoryImpl implements ProjectRepository {

    private SessionFactory sessionFactory;

    @Autowired
    public ProjectRepositoryImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    @SuppressWarnings("unchecked")
    public List<Project> listAllProjects() {
        Criteria criteria = getSession().createCriteria(Project.class);
        return (List<Project>) criteria.list();
    }

    public void saveOrUpdate(Project project) {
        getSession().saveOrUpdate(project);
    }

    public Project findProjectById(Long id) {
        return  (Project) getSession().get(Project.class, id);
    }

    public void deleteProject(Long id) {
        Project project = (Project) getSession().get(Project.class, id);
        getSession().delete(project);
    }
}
