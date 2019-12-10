package com.matevytskyi.taxreports.repository;

import com.matevytskyi.taxreports.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ClientRepository extends JpaRepository<Client, Long> {

}
