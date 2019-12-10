package com.matevytskyi.taxreports.service;


import com.matevytskyi.taxreports.entity.Client;
import org.springframework.security.core.userdetails.UserDetailsService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

public interface ClientService extends CrudService<Client>, UserDetailsService {

    Client register(Client client);

    Optional<Client> findByEmail(String email);

    boolean addReportToRequest(HttpServletRequest request, int reportId);

    Optional<List<Client>> findClientsByInspectorId(int inspectorId);

    Client assignInspector(Client client);

    // Optional<List<ClientForAdmin>> getAllClientsForInspector();

    //Optional<List<ClientForAdmin>> getClientsForAdminByInspectorId(int inspectorId);
}
