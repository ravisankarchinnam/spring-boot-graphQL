package com.github.ravisankarchinnam.tours.repository;

import com.github.ravisankarchinnam.tours.model.Agency;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AgencyRepository extends JpaRepository<Agency, Long> {
}