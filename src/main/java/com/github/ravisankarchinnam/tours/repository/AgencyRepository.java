package com.github.ravisankarchinnam.tours.repository;

import com.github.ravisankarchinnam.tours.model.Agency;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AgencyRepository extends JpaRepository<Agency, Long> {
    Optional<Agency> findById(Long id);
}