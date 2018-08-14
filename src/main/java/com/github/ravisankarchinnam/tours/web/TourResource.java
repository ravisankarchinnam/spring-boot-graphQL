package com.github.ravisankarchinnam.tours.web;

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
}
