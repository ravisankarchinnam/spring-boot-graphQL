package com.github.ravisankarchinnam.tours.web;


import com.github.ravisankarchinnam.tours.graphql.schema.MutationResolver;
import com.github.ravisankarchinnam.tours.graphql.schema.QueryResolver;
import com.github.ravisankarchinnam.tours.model.Agency;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/rest/agency")
public class AgencyResource {
    @Autowired
    private QueryResolver query;
    @Autowired
    private MutationResolver mutation;



    @GetMapping
    @ResponseBody
    public List<Agency> get() {
        return query.getAllAgencies();
    }



    @GetMapping(value = "{id}")
    @ResponseBody
    public Agency get(@PathVariable("id") Long id) {
        return query.getAgency(id);
    }



    @PostMapping
    @ResponseBody
    public void createAgency(String name, Double rating) {
        mutation.addAgency(name, rating);
    }
}