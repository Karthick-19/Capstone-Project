package com.example.ProjectManagement.Service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ProjectManagement.Entity.Task;
import com.example.ProjectManagement.Entity.TaskStatus;
import com.example.ProjectManagement.Entity.TaskWithProjectDTO;
import com.example.ProjectManagement.Repository.TaskRepository;

@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;

    public Task createTask(Task task) {
        return taskRepository.save(task);
    }

    public Task updateTask(Task task) {
        return taskRepository.save(task);
    }

    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }

    public Task updateTaskStatus(Long taskId, TaskStatus status) {
        Task task = taskRepository.findById(taskId).orElseThrow();
        task.setStatus(status);
        return taskRepository.save(task);
    }

    public Task updateTaskProgress(Long taskId, int progress) {
        Task task = taskRepository.findById(taskId).orElseThrow();
        task.setProgress(progress);
        return taskRepository.save(task);
    }

    public List<Task> getTasksByProject(Long projectId) {
        return taskRepository.findByProjectId(projectId);
    }
    
    public Task getTaskById(Long id) {
        return taskRepository.findById(id)
                .orElseThrow();
    }
    
    public List<Task> getTasksAssignedToUser(String assignedTo) {
        return taskRepository.findByAssignedTo(assignedTo);
    }
    
    public List<Task> findTasksByAssignedTo(String username) {
        return taskRepository.findByAssignedTo(username);
    }
    
    public List<Task> getTasksAssignedToUserWithProject(String username) {
        return taskRepository.findTasksByAssignedToWithProject(username);
    }
    
 // TaskService.java (continued)
    public List<TaskWithProjectDTO> getTasksAssignedToUserWithProjectDTO(String username) {
        List<Task> tasks = taskRepository.findTasksByAssignedToWithProject(username);
        return tasks.stream().map(task -> {
            TaskWithProjectDTO dto = new TaskWithProjectDTO();
            dto.setTaskId(task.getId());
            dto.setTaskName(task.getName());
            dto.setTaskDescription(task.getDescription());
            dto.setStatus(task.getStatus());
//            dto.setAssignedTo(task.getAssignedTo());
            dto.setProjectId(task.getProject().getId());
            dto.setProjectName(task.getProject().getName());
            dto.setProjectDescription(task.getProject().getDescription());
            dto.setDeadline(task.getDeadline());
            dto.setProgress(task.getProgress());
            return dto;
        }).collect(Collectors.toList());
    }

}

