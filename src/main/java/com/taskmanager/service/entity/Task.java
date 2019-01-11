package com.taskmanager.service.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.springframework.format.annotation.DateTimeFormat;

@Entity(name = "TASK")
@Table(name = "TASK")
public class Task {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "TASK_ID")
	private Integer taskId;

	@OneToOne(optional=false)
	@JoinColumn(name="parentId",referencedColumnName="PARENT_ID", insertable=true, updatable=true,nullable=false)
	@NotFound(action=NotFoundAction.IGNORE)    
	private ParentTask parentTask;

	@Column(name = "TASK", length = 25)
	private String task;

	@Column(name = "PRIORITY", length = 25)
	private String priority;

	@Column(name = "START_DATE")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date startDate;

	@Column(name = "END_DATE")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date endDate;
	

	public Integer getTaskId() {
		return taskId;
	}

	public void setTaskId(Integer taskId) {
		this.taskId = taskId;
	}


	public String getTask() {
		return task;
	}

	public void setTask(String task) {
		this.task = task;
	}


	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public ParentTask getParentTask() {
		return parentTask;
	}

	public void setParentTask(ParentTask parentTask) {
		this.parentTask = parentTask;
	}


}
