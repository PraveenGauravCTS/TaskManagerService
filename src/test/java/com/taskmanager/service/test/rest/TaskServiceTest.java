package com.taskmanager.service.test.rest;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.taskmanager.service.manager.TaskManager;
import com.taskmanager.service.rest.TaskService;
import com.taskmanager.service.view.TaskView;

@RunWith(MockitoJUnitRunner.class)
public class TaskServiceTest {

	@InjectMocks
	private TaskService taskService;

	@Mock
	private TaskManager taskManager;

	@Test
	public final void testgetTaskById() throws Exception {
		assertNotNull(taskService.getTaskById(3));
	}


	@Test
	public final void testeditTask() throws Exception {
		TaskView task = new TaskView();
		assertNotNull(taskService.editTask(task));
	}

	@Test
	public final void testaddTask() throws Exception {
		TaskView task = new TaskView();
		assertNotNull(taskService.addTask(task));
	}

	@Test
	public final void testdeleteTask() throws Exception {
		assertNotNull(taskService.deleteTask(3));
	}

}
