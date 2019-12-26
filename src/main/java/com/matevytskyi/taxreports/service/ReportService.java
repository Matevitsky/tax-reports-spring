package com.matevytskyi.taxreports.service;


import com.matevytskyi.taxreports.entity.Report;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ReportService {

    Report create(long userId, String tittle, String content);

    Report save(Report report);

    void deleteById(long id);


    Optional<Report> getById(long id);

    Page<Report> findAll(Pageable pageable);

    List<Report> findNewReports(long inspectorId);

    List<Report> getReportsByClientId(long clientId);

    List<Report> getClientActiveReports(long clientId);

    Report changeStatusToInProgress(Report report);
}
