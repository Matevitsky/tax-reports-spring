package com.matevytskyi.taxreports.service;

import java.util.List;
import java.util.Optional;

public interface CrudService<S> {

    S create(S entity);

    void deleteById(long id);

    S update(S entity);

    Optional<S> getById(long id);

    Optional<List<S>> getAll();
}
