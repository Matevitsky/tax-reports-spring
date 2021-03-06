package com.matevytskyi.taxreports.service;

import com.matevytskyi.taxreports.entity.Report;
import com.matevytskyi.taxreports.entity.ReportStatus;
import com.matevytskyi.taxreports.repository.ReportRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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


    public Report create(String tittle, String content) {
        LOGGER.info("create report start");
        //TODO: implement method with logged user
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        // CustomUser customUser = (CustomUser)authentication.getPrincipal();
        // int userId = customUser.getUserId();
        Report report = Report.builder()
                .id(1)
                .status(ReportStatus.NEW)
                .tittle(tittle)
                .content(content).build();
        return reportRepository.save(report);
    }

    public Report save(Report report) {
        LOGGER.info("save report start");
        return reportRepository.save(report);
    }


    public void deleteById(long id) {
        LOGGER.info("deleteById report start");
        reportRepository.deleteById(id);
    }


    public Optional<Report> getById(long id) {
        return reportRepository.findById(id);
    }


    public Page<Report> findAll(Pageable pageable) {
        return reportRepository.findAll(pageable);
    }

    @Override
    public List<Report> findNewReports(long inspectorId) {
        return reportRepository.findAllByClient_IdAndStatus(inspectorId, ReportStatus.NEW);
    }

    @Override
    public List<Report> getReportsByClientId(long clientId) {
        LOGGER.info("FindAll report by client Id  started");
        return reportRepository.findAllByClient_Id(clientId);
    }

    @Override
    public List<Report> getClientActiveReports(long clientId) {
        return reportRepository.findAllByClient_IdAndStatusNot(clientId, ReportStatus.ACCEPTED);
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
