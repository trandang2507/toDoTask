package com.project.todo.repository;

import com.project.todo.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long>{
    List<Task> findByCompleted(boolean completed);
    List<Task> findByTitleContainingIgnoreCase(String keyword);
}
