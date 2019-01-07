package com.taskmanager.service.manager;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taskmanager.service.entity.ParentTask;
import com.taskmanager.service.repository.ParentTaskRepository;
import com.taskmanager.service.view.BaseView;
import com.taskmanager.service.view.ParentTaskView;
import com.taskmanager.service.view.ParentTaskViews;

@Service
public class ParentTaskManager {

	@Autowired
	private ParentTaskRepository parentTaskRepository;

	public BaseView getParentTaskById(int inProjectId) throws Exception{
		ParentTask parentTask = parentTaskRepository.findOne(inProjectId);
		ParentTaskView parentTaskView = new ParentTaskView();
		BeanUtils.copyProperties(parentTask, parentTaskView);
		return parentTaskView;
	}

	public BaseView getParentTasks(String inSearchKey) throws Exception{
		Iterable<ParentTask> parentTaskModels = parentTaskRepository.getParentTaskDetails(inSearchKey);
		List<ParentTaskView> parentTaskViews = new ArrayList<>();
		if (parentTaskModels != null) {
			for (ParentTask parentTaskModel : parentTaskModels) {
				ParentTaskView parentTaskView = new ParentTaskView();
				BeanUtils.copyProperties(parentTaskModel, parentTaskView);
				parentTaskViews.add(parentTaskView);
			}
		}
		ParentTaskViews parentTaskView = new ParentTaskViews();
		parentTaskView.setParentTaskViews(parentTaskViews);
		return parentTaskView;

	}
	
	public BaseView listParentTasks() throws Exception{
		Iterable<ParentTask> parentTaskModels = parentTaskRepository.listParentTasks();
		List<ParentTaskView> parentTaskViews = new ArrayList<>();
		if (parentTaskModels != null) {
			for (ParentTask parentTaskModel : parentTaskModels) {
				ParentTaskView parentTaskView = new ParentTaskView();
				BeanUtils.copyProperties(parentTaskModel, parentTaskView);
				parentTaskViews.add(parentTaskView);
			}
		}
		ParentTaskViews parentTaskView = new ParentTaskViews();
		parentTaskView.setParentTaskViews(parentTaskViews);
		return parentTaskView;

	}

	public void addParentTask(ParentTaskView inParentTaskView) throws Exception{
		ParentTask parentTask = new ParentTask();
		BeanUtils.copyProperties(inParentTaskView, parentTask);
		parentTaskRepository.save(parentTask);
	}

	public void deleteParentTask(int inParentId) throws Exception{
		parentTaskRepository.delete(inParentId);
	}

}
