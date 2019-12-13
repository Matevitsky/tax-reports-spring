package com.matevytskyi.taxreports.service;

import com.matevytskyi.taxreports.entity.Client;
import com.matevytskyi.taxreports.entity.Employee;
import com.matevytskyi.taxreports.entity.User;
import com.matevytskyi.taxreports.repository.ClientRepository;
import com.matevytskyi.taxreports.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService {


    private final ClientRepository clientRepository;

    private final EmployeeRepository employeeRepository;

    @Autowired
    public CustomUserDetailsService(ClientRepository userRepository, EmployeeRepository employeeRepository) {
        this.clientRepository = userRepository;
        this.employeeRepository = employeeRepository;
    }


    public Optional<User> findUserByEmail(String userEmail) throws UsernameNotFoundException {
        Optional<Employee> optionalEmployee = employeeRepository.findByEmail(userEmail);
        if (!optionalEmployee.isPresent()) {
            Optional<Client> optionalClient = clientRepository.findByEmail(userEmail);
            if (!optionalClient.isPresent()) {
                throw new UsernameNotFoundException("Wrong Login");
            } else {
                return Optional.of(optionalClient.get());
            }
        } else {
            return Optional.of(optionalEmployee.get());
        }
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return findUserByEmail(email).orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }
}


