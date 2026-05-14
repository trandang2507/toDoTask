package com.project.todo.controller;

import com.project.todo.model.Task;
import com.project.todo.repository.TaskRepository;
import com.project.todo.service.TaskService;
import com.project.todo.service.TaskServiceImpl;
import jakarta.websocket.server.PathParam;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
@CrossOrigin("*")
public class TaskController {

    private final TaskService taskService;
    private final TaskRepository taskRepository;

    public TaskController(TaskService taskService, TaskRepository taskRepository){
        this.taskService = taskService;
        this.taskRepository = taskRepository;
    }

    @GetMapping
    public List<Task> getAllTasks(){
        return taskService.getAllTask();
    }
    @GetMapping("/{id}")
    public Task getTaskById(@PathVariable long id){
        return taskService.getTaskById(id);
    }

    @PostMapping
    public Task createTask(@RequestBody Task task){
        return taskService.createTask(task);
    }

    @PutMapping("/{id}")
    public Task updateTask(@PathVariable long id, @RequestBody Task task){
        return taskService.updateTask(id,task);
    }
    @PatchMapping("/{id}/complete")
    public Task completeTask(@PathVariable long id){
        return taskService.completeTask(id);
    }
    @DeleteMapping("/{id}")
    public String deleteTask(@PathVariable long id){
        taskService.deleteTask(id);
        return "Xoa thanh cong";
    }

    @GetMapping("/status/{completed}")
    public List<Task> getTaskByCompleted(@PathVariable boolean completed){
        return taskService.getTaskByCompleted(completed);
    }

    @GetMapping("/search")
    public List<Task> searchTasks(@RequestParam String keyWord){
        return taskService.searchTasks(keyWord);
    }

}
