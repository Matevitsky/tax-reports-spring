package com.matevytskyi.taxreports.repository;

import com.matevytskyi.taxreports.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


public interface ClientRepository extends JpaRepository<Client, Long> {

    Optional<Client> findByEmail(String email);

    Optional<List<Client>> findAllByInspectorId(long inspectorId);

}
