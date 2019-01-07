package com.taskmanager.service.manager;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taskmanager.service.constant.ServiceConstant;
import com.taskmanager.service.entity.ParentTask;
import com.taskmanager.service.entity.Task;
import com.taskmanager.service.repository.TaskRepository;
import com.taskmanager.service.view.BaseView;
import com.taskmanager.service.view.TaskView;
import com.taskmanager.service.view.TaskViews;

@Service
public class TaskManager {
	@Autowired
	private TaskRepository taskRepository;

	public BaseView getTaskById(int inTaskId) throws Exception{
		Task taskModel = taskRepository.findOne(inTaskId);
		TaskView taskView = new TaskView();
		if (null != taskModel) {
			BeanUtils.copyProperties(taskModel, taskView);
			taskView.setTaskName(taskModel.getTask());
			taskView.setStartDate(new SimpleDateFormat(ServiceConstant.DISPLAY_DATE_FORMAT).format(taskModel.getStartDate()));
			taskView.setEndDate(new SimpleDateFormat(ServiceConstant.DISPLAY_DATE_FORMAT).format(taskModel.getEndDate()));
		}
		return taskView;
	}

	public BaseView getTasks()  throws Exception{
		Iterable<Task> tasksModel = null;
		try {
		tasksModel = taskRepository.findAll();
		}catch (Exception e) {
			System.out.println(e);
		}
			
		List<TaskView> taskViews = new ArrayList<>();
		if (tasksModel != null) {
			for (Task taskModel : tasksModel) {
				TaskView taskView = new TaskView();
				BeanUtils.copyProperties(taskModel, taskView);
				taskView.setTaskName(taskModel.getTask());
				if(taskModel.getStartDate()!=null) {
					taskView.setStartDate(new SimpleDateFormat(ServiceConstant.DISPLAY_DATE_FORMAT).format(taskModel.getStartDate()));
				}
				if(taskModel.getEndDate()!=null) {
					taskView.setEndDate(new SimpleDateFormat(ServiceConstant.DISPLAY_DATE_FORMAT).format(taskModel.getEndDate()));
				}
				if(taskModel.getParentTask()!=null) {
					taskView.setParentId(""+taskModel.getParentTask().getParentId());
					taskView.setParentTask(taskModel.getParentTask().getParentTask());
				}else {
					taskView.setParentId("0");
					taskView.setParentTask("N/A");
				}
				taskViews.add(taskView);
			}
		}
		TaskViews taskView = new TaskViews();
		taskView.setTaskViews(taskViews);
		return taskView;
	}

	public void addTask(TaskView inTaskView) throws Exception{
		Task task = new Task();
		ParentTask parentTask = new ParentTask();
		BeanUtils.copyProperties(inTaskView, task);
		try {
			task.setTask(inTaskView.getTaskName());
			task.setStartDate(new SimpleDateFormat(ServiceConstant.DISPLAY_DATE_FORMAT).parse(inTaskView.getStartDate()));
			task.setEndDate(new SimpleDateFormat(ServiceConstant.DISPLAY_DATE_FORMAT).parse(inTaskView.getEndDate()));
			parentTask.setParentId(NumberUtils.toInt(inTaskView.getParentId()));
			task.setParentTask(parentTask);
		} catch (ParseException e) {
			//Consume exception
		}
		taskRepository.save(task);
	}

	public void editTask(TaskView inTaskView) throws Exception{
		Task task = taskRepository.findOne(inTaskView.getTaskId());
		if (null != task) {
			BeanUtils.copyProperties(inTaskView, task);
			try {
				task.setTask(inTaskView.getTaskName());
				task.setStartDate(new SimpleDateFormat(ServiceConstant.DISPLAY_DATE_FORMAT).parse(inTaskView.getStartDate()));
				task.setEndDate(new SimpleDateFormat(ServiceConstant.DISPLAY_DATE_FORMAT).parse(inTaskView.getEndDate()));
			} catch (ParseException e) {
				//Consume exception
			}
			taskRepository.save(task);
		}
	}

	public void deleteTask(int inTaskId) throws Exception{
		taskRepository.delete(inTaskId);
	}

}
