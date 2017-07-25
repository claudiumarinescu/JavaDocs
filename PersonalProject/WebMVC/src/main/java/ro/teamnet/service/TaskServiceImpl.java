package ro.teamnet.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ro.teamnet.dao.interfaces.TaskRepository;
import ro.teamnet.model.Task;
import ro.teamnet.service.interfaces.TaskService;

import java.util.List;

@Service
@Transactional
public class TaskServiceImpl implements TaskService {

    private TaskRepository taskRepository;

    @Autowired
    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> listAllTasks() {
        return taskRepository.listAllTasks();
    }

    public void saveOrUpdate(Task task) {
        taskRepository.saveOrUpdate(task);
    }

    public Task findTaskById(Long id) {
        return taskRepository.findTaskById(id);
    }

    public void deleteTask(Long id) {
        taskRepository.deleteTask(id);
    }

}
