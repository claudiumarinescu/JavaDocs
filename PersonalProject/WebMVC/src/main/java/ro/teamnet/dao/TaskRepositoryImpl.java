package ro.teamnet.dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ro.teamnet.dao.interfaces.TaskRepository;
import ro.teamnet.model.Task;

import java.util.List;

@Repository
public class TaskRepositoryImpl implements TaskRepository {

    private SessionFactory sessionFactory;

    @Autowired
    public TaskRepositoryImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    @SuppressWarnings("unchecked")
    public List<Task> listAllTasks() {
        Criteria criteria = getSession().createCriteria(Task.class);
        return (List<Task>) criteria.list();
    }

    public void saveOrUpdate(Task task) {
        getSession().saveOrUpdate(task);
    }

    public Task findTaskById(Long id) {
        return  (Task) getSession().get(Task.class, id);
    }

    public void deleteTask(Long id) {
        Task task = (Task) getSession().get(Task.class, id);
        getSession().delete(task);
    }
}
