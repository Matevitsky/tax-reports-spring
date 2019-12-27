package com.matevytskyi.taxreports.service;

import com.matevytskyi.taxreports.entity.Client;
import com.matevytskyi.taxreports.entity.Company;
import com.matevytskyi.taxreports.entity.Employee;
import com.matevytskyi.taxreports.repository.ClientRepository;
import com.matevytskyi.taxreports.repository.EmployeeRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

@Service
public class ClientServiceImpl implements ClientService {

    private static final Logger LOGGER = Logger.getLogger(ClientServiceImpl.class);

    private ClientRepository clientRepository;
    private EmployeeRepository employeeRepository;

    @Autowired
    public ClientServiceImpl(ClientRepository clientRepository, EmployeeRepository employeeRepository) {
        this.clientRepository = clientRepository;
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Client create(String firstName,
                         String lastName,
                         String email,
                         String password,
                         String companyName) {
        Client client = Client.builder()
                .firstName(firstName)
                .lastName(lastName)
                .email(email)
                .password(new BCryptPasswordEncoder().encode(password))
                .company(new Company(0L, companyName, null))
                .build();


        return clientRepository.save(assignInspector(client));
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
        //TODO: fix this method with related logic
        Optional<Employee> byId = employeeRepository.findById(2L);
        client.setInspector(byId.get());
        return client;
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
