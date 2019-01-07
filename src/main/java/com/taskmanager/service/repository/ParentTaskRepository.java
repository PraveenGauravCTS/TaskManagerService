package com.taskmanager.service.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.taskmanager.service.entity.ParentTask;

public interface ParentTaskRepository extends CrudRepository<ParentTask, Integer> {

	@Query(" SELECT P FROM PARENTTASK P where PARENT_TASK=(:taskName) ")
	Iterable<ParentTask> getParentTaskDetails(@Param("taskName") String taskName);
	
	@Query(" SELECT P FROM PARENTTASK P")
	Iterable<ParentTask> listParentTasks();

}
