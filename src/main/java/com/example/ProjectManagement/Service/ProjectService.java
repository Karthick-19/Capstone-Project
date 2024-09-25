package com.example.ProjectManagement.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//
//import com.example.ProjectManagement.UserDTO;
//import com.example.ProjectManagement.UserFeignClient;
import com.example.ProjectManagement.Entity.Project;
import com.example.ProjectManagement.Entity.UserDTO;
import com.example.ProjectManagement.Repository.ProjectRepository;

@Service
public class ProjectService {
//	
//	   @Autowired
//	   private UserFeignClient userFeignClient;
	
	@Autowired
    private UserClient userClient;

	
	@Autowired
    private ProjectRepository projectRepository;

    public Project createProject(Project project) {
        return projectRepository.save(project);
    }

    public Project updateProject(Project project) {
        return projectRepository.save(project);
    }

    public void deleteProject(Long id) {
        projectRepository.deleteById(id);
    }

    public Project getProjectById(Long id) {
        return projectRepository.findById(id).orElseThrow();
    }
    
    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }
    
//    public List<Project> getProjectsByUserId(int userId) {
//        UserDTO userDTO = userFeignClient.getUserById(userId);
//
//        if (userDTO != null) {
//            // Retrieve projects where the lead ID matches the user ID
//            return projectRepository.findByLeadId(userDTO.getId());
//        }
//
//        return new ArrayList<>(); // Return an empty list if user not found
//    }
    public List<Project> getProjectsByUserId(int userId) {
        // Fetch the user information from the um microservice
        UserDTO user = userClient.getUserById(userId);

        // Fetch the projects based on the userId
        List<Project> projects = projectRepository.findByLeadId(userId);

        // Optionally attach user information to each project or use it as needed
        // Example: Set the user name or other details in the Project entity
//        projects.forEach(project -> {
//            project.setLeadName(user.getName()); // Assuming Project has a leadName field
//        });

        return projects;
    }
    
    public List<Project> findProjectsByIds(List<Project> projectIds) {
        return projectRepository.findByIdIn(projectIds);
    }

}
