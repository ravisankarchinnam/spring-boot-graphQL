package com.github.ravisankarchinnam.tours.repository;

import com.github.ravisankarchinnam.tours.model.Tour;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TourRepository extends JpaRepository<Tour, Long> {
    Optional<Tour> findById(Long id);
    Optional<Boolean> deleteById(Long id);
}
