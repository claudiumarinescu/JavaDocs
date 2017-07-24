package ro.teamnet.dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ro.teamnet.model.Job;

import java.util.List;

/**
 * Created by Claudiu.Marinescu on 7/24/2017.
 */
@Repository
public class JobRepositoryImpl implements JobRepository {

    private SessionFactory sessionFactory;

    @Autowired
    public JobRepositoryImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    @SuppressWarnings("unchecked")
    public List<Job> listAllJobs() {
        Criteria criteria = getSession().createCriteria(Job.class);
        return (List<Job>) criteria.list();
    }

    public void saveOrUpdate(Job job) {
        getSession().saveOrUpdate(job);
    }

    public Job findJobById(Long id) {
        return  (Job) getSession().get(Job.class, id);
    }

    public void deleteJob(Long id) {
        Job job = (Job) getSession().get(Job.class, id);
        getSession().delete(job);
    }
}
