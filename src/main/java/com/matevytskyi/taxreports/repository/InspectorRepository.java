package com.matevytskyi.taxreports.repository;

import com.matevytskyi.taxreports.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InspectorRepository extends JpaRepository<Employee, Long> {
    Employee findByEmail(String email);

}
