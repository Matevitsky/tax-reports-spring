package com.matevytskyi.taxreports.service;

import com.matevytskyi.taxreports.entity.Client;
import com.matevytskyi.taxreports.repository.ClientRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

@Service
public class ClientServiceImpl implements ClientService {

    private static final Logger LOGGER = Logger.getLogger(ClientServiceImpl.class);

    private ClientRepository clientRepository;

    @Autowired

    public ClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public Client register(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public Optional<Client> findByEmail(String email) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean addReportToRequest(HttpServletRequest request, int reportId) {
        return false;
    }

    @Override
    public Optional<List<Client>> findClientsByInspectorId(int inspectorId) {
        return Optional.empty();
    }

    @Override
    public Client assignInspector(Client client) {
        return null;
    }


    public Client create(Client entity) {
        return null;
    }


    public void deleteById(long id) {

    }


    public Client update(Client entity) {
        return null;
    }


    public Optional<Client> getById(long id) {
        return Optional.empty();
    }

    @Override
    public Page<Client> findAll(Pageable pageable) {
        return clientRepository.findAll(pageable);
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return null;
    }
}
