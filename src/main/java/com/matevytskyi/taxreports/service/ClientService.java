package com.matevytskyi.taxreports.service;


import com.matevytskyi.taxreports.entity.Client;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetailsService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

public interface ClientService extends UserDetailsService {


    void deleteById(long id);

    Client update(Client entity);

    Optional<Client> getById(long id);

    Page<Client> findAll(Pageable pageable);


    Client register(Client client);

    Optional<Client> findByEmail(String email);

    boolean addReportToRequest(HttpServletRequest request, int reportId);

    Optional<List<Client>> findClientsByInspectorId(int inspectorId);

    Client assignInspector(Client client);

    // Optional<List<ClientForAdmin>> getAllClientsForInspector();

    //Optional<List<ClientForAdmin>> getClientsForAdminByInspectorId(int inspectorId);
}
