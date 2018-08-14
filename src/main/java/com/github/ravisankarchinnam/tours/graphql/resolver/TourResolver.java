package com.tours.packages.resolver;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.tours.packages.exception.TourNotFoundException;
import com.tours.packages.model.Agency;
import com.tours.packages.model.Tour;
import com.tours.packages.repository.AgencyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TourResolver implements GraphQLResolver<Tour> {
    @Autowired
    private AgencyRepository agencyRepository;



    public Agency getAgency(Tour tour) {
        Agency agency = agencyRepository.findOne(tour.getAgency().getId());
        if (agency == null) {
            throw new TourNotFoundException(tour.getAgency().getId());
        }
        return agency;
    }
}
