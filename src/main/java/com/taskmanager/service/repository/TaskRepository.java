package com.taskmanager.service.repository;

import org.springframework.data.repository.CrudRepository;

import com.taskmanager.service.entity.Task;

public interface TaskRepository extends CrudRepository<Task, Integer> {


}
