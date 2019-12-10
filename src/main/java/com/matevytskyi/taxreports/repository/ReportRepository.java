package com.matevytskyi.taxreports.repository;

import com.matevytskyi.taxreports.entity.Report;
import com.matevytskyi.taxreports.entity.ReportStatus;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;
import java.util.Optional;

public interface ReportRepository extends PagingAndSortingRepository<Report, Long> {
    Optional<List<Report>> findAllByClient_Id(long id);

    Optional<List<Report>> findAllByClient_IdAndAndStatusNot(long clientId, ReportStatus reportStatus);


}
