package com.brano.democp.repository;

import com.brano.democp.entity.AccessType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccessTypeRepository extends JpaRepository<AccessType, Long> {
}
