package com.taskmanager.service.view;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.taskmanager.service.constant.ServiceConstant;

@JsonInclude(Include.NON_NULL)
public class TaskView extends BaseView {

	private Integer taskId;
	private String taskName = null;
	private String parentId = null;
	private String parentTask = null;
	private String status = null;
	private String priority = null;
	private String startDate = null;
	private String endDate = null;


	public Integer getTaskId() {
		return taskId;
	}



	public void setTaskId(Integer taskId) {
		this.taskId = taskId;
	}



	public String getTaskName() {
		return taskName;
	}



	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}



	public String getPriority() {
		return priority;
	}



	public void setPriority(String priority) {
		this.priority = priority;
	}



	public String getStartDate() {
		return startDate;
	}



	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}



	public String getEndDate() {
		return endDate;
	}



	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}



	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		if (ServiceConstant.STATUS_OPEN.equals(status)) {
			this.status = "OPEN";
		} else if (ServiceConstant.STATUS_COMPLETED.equals(status)) {
			this.status = "COMPLETED";
		} else {
			this.status = status;
		}
	}



	public String getParentId() {
		return parentId;
	}



	public void setParentId(String parentId) {
		this.parentId = parentId;
	}



	public String getParentTask() {
		return parentTask;
	}



	public void setParentTask(String parentTask) {
		this.parentTask = parentTask;
	}
	

}
