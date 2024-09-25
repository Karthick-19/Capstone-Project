package com.example.ProjectManagement.Resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ProjectManagement.Entity.Project;
import com.example.ProjectManagement.Entity.Task;
import com.example.ProjectManagement.Entity.TaskWithProjectDTO;
import com.example.ProjectManagement.Service.ProjectService;
import com.example.ProjectManagement.Service.TaskService;

@CrossOrigin
@RestController
@RequestMapping("/projects")
public class ProjectController {
    @Autowired
    private ProjectService projectService;
    
    @Autowired
    private TaskService taskService;

    @PostMapping
    public ResponseEntity<Project> createProject(@RequestBody Project project) {
        return ResponseEntity.ok(projectService.createProject(project));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Project> updateProject(@PathVariable Long id, @RequestBody Project project) {
        project.setId(id);
        return ResponseEntity.ok(projectService.updateProject(project));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProject(@PathVariable Long id) {
        projectService.deleteProject(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Project> getProject(@PathVariable Long id) {
        return ResponseEntity.ok(projectService.getProjectById(id));
    }
    

    @GetMapping
    public ResponseEntity<List<Project>> getAllProjects() {
        List<Project> projects = projectService.getAllProjects();
        return ResponseEntity.ok(projects);
    }
    
    @GetMapping("/{projectId}/tasks")
    public ResponseEntity<List<Task>> getTasksByProject(@PathVariable Long projectId) {
        return ResponseEntity.ok(taskService.getTasksByProject(projectId));
    }
    
    @GetMapping("{projectId}/tasks/{id}")
    public ResponseEntity<Task> getTaskById(@PathVariable Long id) {
        Task task = taskService.getTaskById(id);
        return ResponseEntity.ok(task);
    }
    
    @GetMapping("/user/{userId}")
    public List<Project> getProjectsByUserId(@PathVariable int userId) {
        return projectService.getProjectsByUserId(userId);
    }
    
//    @GetMapping("/assigned/{userId}")
//    public List<Task> getTasksAssignedToUser(@PathVariable("userId") String userId) {
//        return taskService.getTasksAssignedToUser(userId);
//    }
    
    @GetMapping("/assigned/{username}")
    public ResponseEntity<List<TaskWithProjectDTO>> getTasksAssignedToUser(@PathVariable String username) {
        List<TaskWithProjectDTO> tasksWithProjects = taskService.getTasksAssignedToUserWithProjectDTO(username);
        return ResponseEntity.ok(tasksWithProjects);
    }
//    @GetMapping("/assigned-details/{username}")
//    public List<ProjectDetailsDTO> getProjectsWithAssignedTasks(@PathVariable String username) {
//        // Fetch tasks assigned to the username
//        List<Task> assignedTasks = taskService.findTasksByAssignedTo(username);
//        
//        // Extract project IDs from the tasks
//        List<Project> projectIds = assignedTasks.stream()
//                                             .map(Task::getProject)
//                                             .distinct()
//                                             .collect(Collectors.toList());
//
//        // Fetch projects based on project IDs
//        List<Project> projects = projectService.findProjectsByIds(projectIds);
//
//        // Map projects to DTOs with tasks
//        return projects.stream().map(project -> {
//            List<Task> tasksForProject = assignedTasks.stream()
//                                                      .filter(task -> task.getProject().equals(project.getId()))
//                                                      .collect(Collectors.toList());
//            return new ProjectDetailsDTO(project, tasksForProject);
//        }).collect(Collectors.toList());
//    }
    
}

