package com.matevytskyi.taxreports.repository;

import com.matevytskyi.taxreports.entity.Request;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface RequestInspectorChangeRepository extends PagingAndSortingRepository<Request, Long> {
}
