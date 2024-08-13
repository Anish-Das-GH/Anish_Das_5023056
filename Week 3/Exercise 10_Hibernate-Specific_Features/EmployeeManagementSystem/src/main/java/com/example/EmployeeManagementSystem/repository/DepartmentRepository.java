package com.example.EmployeeManagementSystem.repository;

import com.example.EmployeeManagementSystem.dto.DepartmentDto;
import com.example.EmployeeManagementSystem.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DepartmentRepository extends JpaRepository<Department, Long> {

    @Query("SELECT new com.example.EmployeeManagementSystem.dto.DepartmentDto(d.id, d.name) FROM Department d")
    List<DepartmentDto> findAllDepartmentDtos();
}
