package com.github.ravisankarchinnam.tours.repository;

import com.github.ravisankarchinnam.tours.model.Tour;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TourRepository extends JpaRepository<Tour, Long> {
}
