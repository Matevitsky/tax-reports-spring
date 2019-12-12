package com.matevytskyi.taxreports.repository;

import com.matevytskyi.taxreports.entity.Report;
import com.matevytskyi.taxreports.entity.ReportStatus;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface ReportRepository extends PagingAndSortingRepository<Report, Long> {
    List<Report> findAllByClient_Id(long id);

    List<Report> findAllByClient_IdAndStatusNot(long clientId, ReportStatus reportStatus);

    List<Report> findAllByClient_IdAndStatus(long clientId, ReportStatus reportStatus);

}
