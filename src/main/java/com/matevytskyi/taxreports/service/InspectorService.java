package com.matevytskyi.taxreports.service;


import com.matevytskyi.taxreports.entity.Employee;
import com.matevytskyi.taxreports.entity.Report;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface InspectorService {

    Employee create(Employee inspecotor);

    void deleteById(long id);

    Employee update(Employee inspector);

    Optional<Employee> getById(long id);

    Page<Employee> findAll(Pageable pageable);

    Employee findByEmail(String email);

    List<Report> getReports(int inspectorId);

    List<Report> getNewReports(int inspectorId);

    boolean acceptReport(int reportId);

    boolean declineReport(int reportId, String reasonToReject);

    Employee getFreeInspector();

}
