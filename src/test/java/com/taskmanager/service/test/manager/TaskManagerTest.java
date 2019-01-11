package com.taskmanager.service.test.manager;

import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.data.domain.Sort;

import com.taskmanager.service.constant.ServiceConstant;
import com.taskmanager.service.entity.Task;
import com.taskmanager.service.manager.TaskManager;
import com.taskmanager.service.repository.TaskRepository;
import com.taskmanager.service.view.TaskView;

@RunWith(MockitoJUnitRunner.class)
public class TaskManagerTest {

	@InjectMocks
	private TaskManager taskManager;

	@Mock
	private TaskRepository taskRepository;

	@Test
	public final void testgetTaskById() throws Exception {
		Task task = new Task();
		task.setEndDate(new Date());
		task.setStartDate(new Date());
		Mockito.when(taskRepository.findOne(3)).thenReturn(task);
		assertNotNull(taskManager.getTaskById(3));
	}





	@Test
	public final void testgetTasks() throws Exception {
		Task task = new Task();
		task.setEndDate(new Date());
		task.setStartDate(new Date());
		ArrayList<Task> tasks = new ArrayList<>();
		tasks.add(task);

	}


	@Test
	public final void testdeleteTask() throws Exception {
		taskManager.deleteTask(3);
	}

}
