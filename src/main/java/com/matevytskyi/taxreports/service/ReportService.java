package com.matevytskyi.taxreports.service;


import com.matevytskyi.taxreports.entity.Report;
import com.matevytskyi.taxreports.entity.ReportStatus;
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

    //  List<Report> getReportsByInspectorId(long inspectorId);

    List<Report> getReportsByClientId(long clientId);

    List<Report> findAllByClient_IdAndStatus(long clientId, ReportStatus reportStatus);

    List<Report> getClientActiveReports(long clientId);

    Report changeStatusToInProgress(Report report);
}
