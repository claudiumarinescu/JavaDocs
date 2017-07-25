package ro.teamnet.dao.interfaces;

import ro.teamnet.model.Task;

import java.util.List;


public interface TaskRepository {

    List<Task> listAllTasks();

    void saveOrUpdate(Task job);

    Task findTaskById(Long id);

    void deleteTask(Long id);

}
