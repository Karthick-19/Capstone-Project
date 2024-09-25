package com.example.ProjectManagement.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.ProjectManagement.Entity.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findByProjectId(Long projectId);

	List<Task> findByAssignedTo(String assignedTo);
	
	 @Query
	 ("SELECT t FROM Task t JOIN FETCH t.project WHERE t.assignedTo = :username")
	    List<Task> findTasksByAssignedToWithProject(@Param("username") String username);
}

