package com.github.ravisankarchinnam.tours.graphql.schema;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.github.ravisankarchinnam.tours.enums.TourType;
import com.github.ravisankarchinnam.tours.exception.AgencyNotFoundException;
import com.github.ravisankarchinnam.tours.exception.TourNotFoundException;
import com.github.ravisankarchinnam.tours.graphql.input.CreateTourInput;
import com.github.ravisankarchinnam.tours.graphql.input.UpdateTourInput;
import com.github.ravisankarchinnam.tours.model.Agency;
import com.github.ravisankarchinnam.tours.model.Tour;
import com.github.ravisankarchinnam.tours.repository.AgencyRepository;
import com.github.ravisankarchinnam.tours.repository.TourRepository;
import org.apache.commons.lang3.StringUtils;
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



    // createTour(input: CreateTourInput!) : Tour!
    @Transactional
    public Tour createTour(CreateTourInput tourInput) {
        Agency agency = getAgencyById(tourInput.getAgency());
        return tourRepository.saveAndFlush(new Tour(null, tourInput.getName(), tourInput.getPrice(),
                tourInput.getDuration(), tourInput.getDescription(), tourInput.getType(), agency));
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
    public boolean deleteTour(Long id) {
        return tourRepository.deleteById(id)
                .orElseThrow(() -> new TourNotFoundException(id));

    }



    // updateTour(input: UpdateTourInput!) : Tour!
    @Transactional
    public Tour updateTour(UpdateTourInput tourInput) {
        Agency agency = getAgencyById(tourInput.getAgency());
        final Long tourId = tourInput.getId();
        Tour tour = getTour(tourId);
        String name = tourInput.getName();
        String price = tourInput.getPrice();
        if (StringUtils.isNotEmpty(name)) tour.setName(name);
        if (StringUtils.isNotEmpty(price)) tour.setPrice(price);
        if (tourInput.getType() != null) tour.setType(tourInput.getType());
        tour.setAgency(agency);

        return tourRepository.save(tour);
    }



    @NotNull
    private Tour getTour(Long pTourId) {
        return tourRepository.findById(pTourId)
                .orElseThrow(() -> new TourNotFoundException(pTourId));
    }



    @NotNull
    private Agency getAgencyById(Long agencyId) {
        return agencyRepository.findById(agencyId)
                .orElseThrow(() -> new AgencyNotFoundException(agencyId));
    }
}
