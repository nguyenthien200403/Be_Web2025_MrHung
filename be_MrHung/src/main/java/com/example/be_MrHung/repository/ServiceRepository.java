package com.example.be_MrHung.repository;


import com.example.be_MrHung.models.Service;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ServiceRepository extends JpaRepository<Service, Integer> {
    List<Service> findByIsActive(Boolean isActive);
    List<Service> findByType(Service.ServiceType type);
}