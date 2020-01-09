package com.matevytskyi.taxreports.service;

import com.matevytskyi.taxreports.entity.Client;
import com.matevytskyi.taxreports.entity.Report;
import com.matevytskyi.taxreports.entity.ReportStatus;
import com.matevytskyi.taxreports.repository.ClientRepository;
import com.matevytskyi.taxreports.repository.ReportRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReportServiceImpl implements ReportService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ReportServiceImpl.class);

    private ReportRepository reportRepository;
    private ClientRepository clientRepository;

    @Autowired
    public ReportServiceImpl(ReportRepository reportRepository, ClientRepository clientRepository) {
        this.reportRepository = reportRepository;
        this.clientRepository = clientRepository;
    }


    public Report create(long clientId, String tittle, String content) {
        LOGGER.debug("create report start");
        //TODO: implement exception handler as required
        Optional<Client> optionalClient = clientRepository.findById(clientId);
        Client client = null;
        if (optionalClient.isPresent()) {
            client = optionalClient.get();
        }


        Report report = Report.builder()
                .client(client)
                .status(ReportStatus.NEW)
                .tittle(tittle)
                .content(content).build();
        return reportRepository.save(report);
    }

    public Report save(Report report) {
        LOGGER.debug("save report start");
        return reportRepository.save(report);
    }


    public void deleteById(long id) {
        LOGGER.debug("deleteById report start");
        reportRepository.deleteById(id);
    }


    public Optional<Report> getById(long id) {
        return reportRepository.findById(id);
    }


    public Page<Report> findAll(Pageable pageable) {
        return reportRepository.findAll(pageable);
    }

    @Override
    public List<Report> getReportsByClientId(long clientId) {
        LOGGER.debug("FindAll report by client Id  started");
        return reportRepository.findAllByClient_Id(clientId);
    }

    @Override
    public List<Report> findAllByClient_IdAndStatus(long clientId, ReportStatus reportStatus) {
        LOGGER.debug("FindAll report by client Id  started");
        Optional<List<Report>> allByClient_idAndStatus = reportRepository.findAllByClient_IdAndStatus(clientId, reportStatus);
        if (!allByClient_idAndStatus.isPresent()) {
            LOGGER.info("no NEW reports for clientId " + clientId);
            return List.of();
        }
        return allByClient_idAndStatus.get();
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
