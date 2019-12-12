package com.matevytskyi.taxreports.service;


import com.matevytskyi.taxreports.entity.Request;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface RequestService {

    Request create(Request request);

    void deleteById(long id);

    Request update(Request request);

    Optional<Request> getById(long id);

    Page<Request> findAll(Pageable pageable);

    boolean deleteByClientID(int clientId);
}
