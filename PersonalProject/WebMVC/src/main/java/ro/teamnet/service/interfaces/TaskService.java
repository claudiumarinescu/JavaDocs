package ro.teamnet.service.interfaces;

import ro.teamnet.model.Task;

import java.util.List;


public interface TaskService {

    List<Task> listAllTasks();

    void saveOrUpdate(Task task);

    Task findTaskById(Long id);

    void deleteTask(Long id);

}
