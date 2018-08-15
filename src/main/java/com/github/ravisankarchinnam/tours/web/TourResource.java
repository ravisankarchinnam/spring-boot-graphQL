package com.github.ravisankarchinnam.tours.web;

import com.github.ravisankarchinnam.tours.dto.TourDTO;
import com.github.ravisankarchinnam.tours.enums.TourType;
import com.github.ravisankarchinnam.tours.graphql.schema.MutationResolver;
import com.github.ravisankarchinnam.tours.graphql.schema.QueryResolver;
import com.github.ravisankarchinnam.tours.model.Tour;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/rest/tour")
public class TourResource {
    @Autowired
    private QueryResolver query;

    @Autowired
    private MutationResolver mutation;



    @GetMapping
    @ResponseBody
    public List<Tour> get() {
        return query.getAllTours();
    }



    @GetMapping(value = "{id}")
    @ResponseBody
    public Tour get(@PathVariable("id") Long id) {
        return query.getTour(id);
    }



    @PostMapping
    @ResponseBody
    public Tour create(@RequestBody TourDTO tour) {
        return mutation.createTour(tour.getName(), tour.getPrice(), tour.getDuration(),
                tour.getDescription(), TourType.valueOf(tour.getType()), tour.getAgencyId());
    }
}
