package com.matevytskyi.taxreports.service;


import com.matevytskyi.taxreports.entity.Report;

import java.util.List;
import java.util.Optional;

public interface ReportService extends CrudService<Report> {

    Optional<List<Report>> getReportsByClientId(long clientId);

    Optional<List<Report>> getClientActiveReports(long clientId);

    Report changeStatusToInProgress(Report report);
}
