package com.github.ravisankarchinnam.tours.graphql.schema;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.github.ravisankarchinnam.tours.exception.AgencyNotFoundException;
import com.github.ravisankarchinnam.tours.exception.TourNotFoundException;
import com.github.ravisankarchinnam.tours.model.Agency;
import com.github.ravisankarchinnam.tours.model.Tour;
import com.github.ravisankarchinnam.tours.repository.AgencyRepository;
import com.github.ravisankarchinnam.tours.repository.TourRepository;
import com.github.ravisankarchinnam.tours.enums.TourType;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class MutationResolver implements GraphQLMutationResolver {

    @Autowired
    private TourRepository tourRepository;
    @Autowired
    private AgencyRepository agencyRepository;



    // createTour(name: String!, price: String!, duration: String, description: String, type: TourType!, agency: ID!) : Tour!
    @Transactional
    public Tour createTour(String name, String price, String duration, String description, TourType tourType, Long agencyId) {
        Agency agency = getAgencyById(agencyId);
        return tourRepository.saveAndFlush(new Tour(null, name, price, duration, description, tourType, agency));
    }



    // addAgency(name: String!, rating: Float) : Agency!
    @Transactional
    public Agency addAgency(String name, Double rating) {
        return agencyRepository.saveAndFlush(new Agency(null, name, rating));
    }



    // updateAgencyRating(id: ID!, rating: Float!) : Agency!
    @Transactional
    public Agency updateAgencyRating(Long id, Double rating) {
        Agency agency = getAgencyById(id);
        agency.setRating(rating);
        return agencyRepository.save(agency);

    }



    // deleteTour(id: ID!) : Long!
    @Transactional
    public boolean deleteTour(Long id) throws TourNotFoundException {
        tourRepository.delete(id);
        return true;
    }



    // updateTour(id: ID!, name: String!, price: String!, duration: String, description: String, type: TourType!, agency: ID!) : Tour!
    @Transactional
    public Tour updateTour(Long id, String name, String price, String duration, String description, TourType type, Long agencyId) {
        Agency agency = getAgencyById(agencyId);
        Tour tour = tourRepository.findOne(id);
        if (tour == null) {
            throw new TourNotFoundException(id);
        }
        tour.setName(name);
        tour.setPrice(price);
        tour.setType(type);
        tour.setAgency(agency);

        return tourRepository.save(tour);
    }



    @NotNull
    private Agency getAgencyById(Long agencyId) {
        Agency agency = agencyRepository.findOne(agencyId);
        if (agency == null) {
            throw new AgencyNotFoundException(agencyId);
        }
        return agency;
    }
}
