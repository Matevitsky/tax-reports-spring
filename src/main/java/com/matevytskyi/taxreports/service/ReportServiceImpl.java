package com.matevytskyi.taxreports.service;

import com.matevytskyi.taxreports.entity.Report;
import com.matevytskyi.taxreports.entity.ReportStatus;
import com.matevytskyi.taxreports.repository.ReportRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReportServiceImpl implements ReportService {

    private static final Logger LOGGER = Logger.getLogger(ReportServiceImpl.class);

    private ReportRepository reportRepository;

    @Autowired
    public ReportServiceImpl(ReportRepository reportRepository) {
        this.reportRepository = reportRepository;
    }

    @Override
    public Report create(Report report) {
        LOGGER.debug("save report start");
        return reportRepository.save(report);
    }

    @Override
    public void deleteById(long id) {
        LOGGER.debug("deleteById report start");
        reportRepository.deleteById(id);
    }

    @Override
    public Report update(Report report) {

        //TODO: check how to implement
        return reportRepository.save(report);
    }

    @Override
    public Optional<Report> getById(long id) {
        return reportRepository.findById(id);
    }

    @Override
    public Page<Report> findAll(Pageable pageable) {
        return reportRepository.findAll(pageable);
    }

    @Override
    public Optional<List<Report>> getReportsByClientId(long clientId) {
        LOGGER.debug("FindAll report by client Id  started");
        return reportRepository.findAllByClient_Id(clientId);
    }

    @Override
    public Optional<List<Report>> getClientActiveReports(long clientId) {
        return reportRepository.findAllByClient_IdAndAndStatusNot(clientId, ReportStatus.ACCEPTED);
    }

    @Override
    public Report changeStatusToInProgress(Report report) {
        Report reportInProgress = Report.builder()
                .id(report.getId())
                .tittle(report.getTittle())
                .content(report.getContent())
                .reasonToReject(report.getReasonToReject())
                .status(ReportStatus.IN_PROGRESS)
                .client(report.getClient())
                .build();

        return reportRepository.save(reportInProgress);

    }
}
