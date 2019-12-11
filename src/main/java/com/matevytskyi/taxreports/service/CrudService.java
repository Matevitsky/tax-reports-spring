package com.matevytskyi.taxreports.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface CrudService<S> {

    S create(S entity);

    void deleteById(long id);

    S update(S entity);

    Optional<S> getById(long id);

    Page<S> findAll(Pageable pageable);
}
