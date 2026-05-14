package com.project.todo.service;

import com.project.todo.model.Task;
import java.util.List;

public interface TaskService {
    List<Task> getAllTask();
    Task getTaskById(Long id);
    Task createTask(Task task);
    Task updateTask(Long id, Task task);
    Task completeTask(Long id);

    void deleteTask(Long id);

    List<Task> getTaskByCompleted(boolean completed);

    List<Task> searchTasks(String keyWord);
}
