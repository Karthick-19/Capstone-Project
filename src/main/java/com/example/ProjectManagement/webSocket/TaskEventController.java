package com.example.ProjectManagement.webSocket;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;

import com.example.ProjectManagement.Entity.Task;
import com.example.ProjectManagement.Service.TaskService;

@CrossOrigin(origins = "http://localhost:4200")
@Controller
public class TaskEventController {

    private final SimpMessagingTemplate messagingTemplate;
    private final TaskService taskService;

    @Autowired
    public TaskEventController(SimpMessagingTemplate messagingTemplate, TaskService taskService) {
        this.messagingTemplate = messagingTemplate;
        this.taskService = taskService;
    }

    /**
     * Notify the assigned user when a new task is created and assigned to them.
     *
     * @param assignedTo the username (email) of the assigned user.
     * @param task       the task that has been assigned.
     */
    public void notifyTaskAssigned(String assignedTo, Task task) {
        // Construct the message payload or simply send the task object
        messagingTemplate.convertAndSend("/topic/tasks/" + assignedTo, task);
        System.out.println("Task assigned notification sent to user: " + assignedTo);
    }

    /**
     * Notify the user who assigned the task when it's completed by another user.
     *
     * @param assignedBy the username (email) of the user who assigned the task.
     * @param task       the task that has been completed.
     */
    public void notifyTaskCompleted(String assignedBy, Task task) {
        // Construct the message payload or simply send the task object
        messagingTemplate.convertAndSend("/topic/completions/" + assignedBy, task);
        System.out.println("Task completion notification sent to user: " + assignedBy);
    }
    
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/ws")
                .setAllowedOriginPatterns("http://localhost:4200") // Use your frontend domain here
                .setAllowedOriginPatterns("http://your-frontend-domain.com") // Add more as needed
//                .setAllowedCredentials(true)
                .withSockJS();
    }
}
