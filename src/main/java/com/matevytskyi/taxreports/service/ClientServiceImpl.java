package com.matevytskyi.taxreports.service;

import com.matevytskyi.taxreports.entity.Client;
import com.matevytskyi.taxreports.entity.Company;
import com.matevytskyi.taxreports.entity.Employee;
import com.matevytskyi.taxreports.repository.ClientRepository;
import com.matevytskyi.taxreports.repository.EmployeeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ClientServiceImpl implements ClientService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ClientServiceImpl.class);

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
                .inspector(assignInspector())
                .build();


        return clientRepository.save(client);
    }

    @Override
    public Optional<Client> findByEmail(String email) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean addReportToRequest(HttpServletRequest request, long reportId) {
        return false;
    }

    @Override
    public List<Client> findClientsByInspectorId(long inspectorId) {

        Optional<List<Client>> allByInspectorId = clientRepository.findAllByInspectorId(inspectorId);

        if (!allByInspectorId.isPresent()) {
            LOGGER.info("no clients for inspector id " + inspectorId);
            return new ArrayList<>();
        }
        return allByInspectorId.get();
    }

    @Override
    public Employee assignInspector() {
        //TODO: fix this method with related logic
        Optional<Employee> byId = employeeRepository.findById(2L);
        Employee employee = new Employee();
        employee = byId.get();

        return employee;
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
