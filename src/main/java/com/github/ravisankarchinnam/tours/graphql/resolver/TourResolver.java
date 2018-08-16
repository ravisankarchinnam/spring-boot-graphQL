package com.github.ravisankarchinnam.tours.graphql.resolver;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.github.ravisankarchinnam.tours.exception.TourNotFoundException;
import com.github.ravisankarchinnam.tours.model.Agency;
import com.github.ravisankarchinnam.tours.model.Tour;
import com.github.ravisankarchinnam.tours.repository.AgencyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TourResolver implements GraphQLResolver<Tour> {
    @Autowired
    private AgencyRepository agencyRepository;



    public Agency getAgency(Tour tour) {
        final Long tourId = tour.getAgency().getId();
        return agencyRepository.findById(tourId)
                .orElseThrow(() -> new TourNotFoundException(tourId));
    }
}
