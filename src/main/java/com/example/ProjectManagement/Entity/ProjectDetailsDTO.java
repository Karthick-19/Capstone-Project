package com.example.ProjectManagement.Entity;

//ProjectDetailsDTO.java

import java.util.List;

public class ProjectDetailsDTO {

 private Project project;
 private List<Task> tasks;

 public ProjectDetailsDTO(Project project, List<Task> tasks) {
     this.project = project;
     this.tasks = tasks;
 }

 // Getters and Setters
 public Project getProject() {
     return project;
 }

 public void setProject(Project project) {
     this.project = project;
 }

 public List<Task> getTasks() {
     return tasks;
 }

 public void setTasks(List<Task> tasks) {
     this.tasks = tasks;
 }
}

