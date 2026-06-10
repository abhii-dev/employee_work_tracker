package com.track.repository;

import com.track.entity.Manager;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ManagerRepository extends JpaRepository<Manager, Long> {

    boolean existsByManagerCode(String managerCode);

    boolean existsByEmail(String email);
}