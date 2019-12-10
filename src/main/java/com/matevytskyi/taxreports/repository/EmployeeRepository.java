package com.matevytskyi.taxreports.repository;

import com.matevytskyi.taxreports.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}

