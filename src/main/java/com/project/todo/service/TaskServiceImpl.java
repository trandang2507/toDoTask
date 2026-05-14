package com.project.todo.service;

import com.project.todo.model.Task;
import com.project.todo.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService{

    private final TaskRepository taskRepository;

    public TaskServiceImpl(TaskRepository taskRepository){
        this.taskRepository = taskRepository;
    }

    @Override
    public List<Task> getAllTask(){
        return taskRepository.findAll();
    }
    @Override
    public Task getTaskById(Long id) {
        return taskRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Không tìm thấy task id = " + id));
    }
    @Override
    public Task createTask(Task task){
        if (task.getTitle().isBlank())
            throw new RuntimeException("Tile khong duoc de trong");
        return taskRepository.save(task);
    }
    @Override
    public Task updateTask(Long id, Task task){

        Task exist = getTaskById(id);

        exist.setTitle(task.getTitle());
        exist.setDescription(task.getDescription());
        exist.setCompleted(task.isCompleted());

        return taskRepository.save(exist);
    }

    @Override
    public Task completeTask(Long id){
        Task task = getTaskById(id);

        task.setCompleted(true);
        return taskRepository.save(task);
    }

    @Override
    public void deleteTask(Long id){
        Task task = getTaskById(id);
        taskRepository.delete(task);
    }

    @Override
    public List<Task> getTaskByCompleted(boolean completed){
        return taskRepository.findByCompleted(completed);
    }

    @Override
    public List<Task> searchTasks(String keyWord){
        return taskRepository.findByTitleContainingIgnoreCase(keyWord);
    }
}
