package com.example.EmployeeManagementSystem.repository;

import com.example.EmployeeManagementSystem.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    List<Employee> findByName(String name);

    List<Employee> findByDepartmentId(Long departmentId);

    boolean existsByEmail(String email);

    @Query("SELECT e FROM Employee e WHERE e.email LIKE %?1%")
    List<Employee> findByEmailContaining(String emailFragment);
}
