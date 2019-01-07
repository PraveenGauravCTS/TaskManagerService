package com.taskmanager.service.view;

import java.util.List;

public class TaskViews extends BaseView {

	List<TaskView> taskViews = null;

	public List<TaskView> getTaskViews() {
		return taskViews;
	}

	public void setTaskViews(List<TaskView> inTaskViews) {
		taskViews = inTaskViews;
	}

}
