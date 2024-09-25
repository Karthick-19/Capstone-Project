package com.example.ProjectManagement.Entity;

import java.util.Date;

//TaskWithProjectDTO.java
public class TaskWithProjectDTO {
	 private int taskId;
	    private String name;
	    private String description;
	    private TaskStatus status;
	    private int progress;
	    private Date deadline;
	    private Long projectId;
	    private String projectName;
	    private String projectDescription;
 
 public TaskWithProjectDTO() {}
 
public TaskWithProjectDTO(int taskId, String taskName, String taskDescription, TaskStatus username, String assignedTo,int progress
		,Long projectId, String projectName, String projectDescription,Date deadline) {
	super();
	this.taskId = taskId;
	this.name = taskName;
	this.description = taskDescription;
	this.status = username;
	this.projectId = projectId;
	this.projectName = projectName;
	this.projectDescription = projectDescription;
	this.deadline=deadline;
	this.progress = progress;
}
public int getTaskId() {
	return taskId;
}
public void setTaskId(int taskId) {
	this.taskId = taskId;
}
public String getTaskName() {
	return name;
}
public void setTaskName(String taskName) {
	this.name = taskName;
}
public String getTaskDescription() {
	return description;
}
public void setTaskDescription(String taskDescription) {
	this.description = taskDescription;
}
public TaskStatus getStatus() {
	return status;
}
public void setStatus(TaskStatus taskStatus) {
	this.status = taskStatus;
}
//public String getAssignedTo() {
//	return assignedTo;
//}
//public void setAssignedTo(String assignedTo) {
//	this.assignedTo = assignedTo;
//}
public Long getProjectId() {
	return projectId;
}
public void setProjectId(Long projectId) {
	this.projectId = projectId;
}
public String getProjectName() {
	return projectName;
}
public void setProjectName(String projectName) {
	this.projectName = projectName;
}
public String getProjectDescription() {
	return projectDescription;
}
public void setProjectDescription(String projectDescription) {
	this.projectDescription = projectDescription;
}

public int getProgress() {
	return progress;
}

public void setProgress(int progress) {
	this.progress = progress;
}

public Date getDeadline() {
	return deadline;
}

public void setDeadline(Date deadline) {
	this.deadline = deadline;
}

 // Constructors, getters, and setters...
 
}

