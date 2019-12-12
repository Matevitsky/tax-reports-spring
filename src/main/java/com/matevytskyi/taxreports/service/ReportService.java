package com.matevytskyi.taxreports.service;


import com.matevytskyi.taxreports.entity.Report;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ReportService {

    Report create(String tittle, String content);

    void deleteById(long id);

    Report update(Report report);

    Optional<Report> getById(long id);

    Page<Report> findAll(Pageable pageable);


    Optional<List<Report>> getReportsByClientId(long clientId);

    Optional<List<Report>> getClientActiveReports(long clientId);

    Report changeStatusToInProgress(Report report);
}
