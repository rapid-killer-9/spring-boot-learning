package com.springbootwebtutorial.springbootwebtutorial.repositories;

import com.springbootwebtutorial.springbootwebtutorial.entities.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepositories extends JpaRepository<EmployeeEntity,Long> {
}
