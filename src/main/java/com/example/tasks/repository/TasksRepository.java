package com.example.tasks.repository;

import com.example.tasks.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;


public interface TasksRepository extends JpaRepository<Task, Long> {
    List<Task> findAllByOrderByDeadlineAsc();
}
