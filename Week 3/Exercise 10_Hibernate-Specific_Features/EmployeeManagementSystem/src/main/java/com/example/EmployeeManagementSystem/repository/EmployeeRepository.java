package com.example.EmployeeManagementSystem.repository;

import com.example.EmployeeManagementSystem.dto.EmployeeDto;
import com.example.EmployeeManagementSystem.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    @Query("SELECT new com.example.EmployeeManagementSystem.dto.EmployeeDto(e.id, e.name, e.email) FROM Employee e")
    List<EmployeeDto> findAllEmployeeDtos();
}
