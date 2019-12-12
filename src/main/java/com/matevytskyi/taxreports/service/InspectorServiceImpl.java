package com.matevytskyi.taxreports.service;

import com.matevytskyi.taxreports.entity.Employee;
import com.matevytskyi.taxreports.entity.Report;
import com.matevytskyi.taxreports.entity.ReportStatus;
import com.matevytskyi.taxreports.repository.ClientRepository;
import com.matevytskyi.taxreports.repository.InspectorRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InspectorServiceImpl implements InspectorService {

    private static final Logger LOGGER = Logger.getLogger(InspectorServiceImpl.class);

    private final InspectorRepository inspectorRepository;
    private final ClientRepository clientRepository;
    private final ReportService reportService;

    @Autowired
    public InspectorServiceImpl(InspectorRepository inspectorRepository, ClientRepository clientRepository, ReportService reportService) {
        this.inspectorRepository = inspectorRepository;
        this.clientRepository = clientRepository;
        this.reportService = reportService;
    }

    @Override
    public Employee create(Employee inspector) {
        LOGGER.debug("create inspecotr started");
        return inspectorRepository.save(inspector);
    }

    @Override
    public void deleteById(long id) {
        LOGGER.debug("deleteById inspecotr started");
        inspectorRepository.deleteById(id);
    }

    @Override
    public Employee update(Employee inspector) {
        LOGGER.debug("update inspecotr started");
        return inspectorRepository.save(inspector);
    }

    @Override
    public Optional<Employee> getById(long id) {
        LOGGER.debug("getById inspecotr started");
        return inspectorRepository.findById(id);
    }

    @Override
    public Page<Employee> findAll(Pageable pageable) {
        LOGGER.debug("findAll inspecotr started");
        return inspectorRepository.findAll(pageable);
    }

    @Override
    public Employee findByEmail(String email) {
        //TODO: check if null
        LOGGER.debug("findByEmail inspecotr started");
        return inspectorRepository.findByEmail(email);
    }

    @Override
    public List<Report> getReports(int inspectorId) {
        LOGGER.debug("getReports inspecotr started");
        return reportService.getReportsByClientId(inspectorId);
    }

    @Override
    public List<Report> getNewReports(int inspectorId) {
        LOGGER.debug("getNewReports inspecotr started");
        return reportService.findNewReports(inspectorId);
    }

    @Override
    public boolean acceptReport(int reportId) {
        LOGGER.debug("acceptReport inspecotr started");
        Report update = null;

        Optional<Report> optionalReport = reportService.getById(reportId);
        if (optionalReport.isPresent()) {
            Report report = optionalReport.get();
            report.setStatus(ReportStatus.ACCEPTED);
            update = reportService.save(report);
        }
        return update != null;
    }


    @Override
    public boolean declineReport(int reportId, String reasonToReject) {
        LOGGER.debug("declineReport inspecotr started");

        Report update = null;
        Optional<Report> optionalReport = reportService.getById(reportId);
        if (optionalReport.isPresent()) {
            Report report = optionalReport.get();
            if (report.getStatus().equals(ReportStatus.ACCEPTED)) {
                LOGGER.info("Can't decline accepted report");
                return false;
            } else {
                report.setStatus(ReportStatus.DECLINED);
                update = reportService.save(report);
            }
        }
        return update != null;
    }


    public Employee getFreeInspector() {
        throw new UnsupportedOperationException();
       /* List<Employee> inspectorList;

        Map<Employee, Integer> map = new HashMap<>();

        Optional<List<Employee>> optionalInspectorList = getAll();

        if (optionalInspectorList.isPresent()) {
            inspectorList = optionalInspectorList.get();
            for (Employee inspector : inspectorList) {
                try (Connection connection = ConnectorDB.getConnection()) {
                    Optional<List<Client>> optionalClients = clientRepository.findClientsByInspectorId(inspector.getId(), connection);
                    optionalClients.ifPresent(clients ->
                            map.put(inspector, clients.size()));
                } catch (SQLException s) {
                    LOGGER.warn("Failed to find client for inspectorId " + inspector.getId());
                }
            }
            if (map.isEmpty()) {
                Optional<Employee> optionalEmployee = getById(1);
                if (optionalEmployee.isPresent()) {
                    return optionalEmployee.get();
                }
            }

        }

        return Collections.min(map.entrySet(),
                Comparator.comparingInt(Map.Entry::getValue)).getKey();*/
    }
}


