package com.github.ravisankarchinnam.tours.exception;

import graphql.ErrorType;
import graphql.GraphQLError;
import graphql.language.SourceLocation;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class AgencyNotFoundException extends RuntimeException implements GraphQLError {

    private Long agencyId;


    private Map<String, Object> extensions = new HashMap<>();



    public AgencyNotFoundException(String message, Long agencyId) {
        super(message);
        extensions.put("agencyId", agencyId);
    }



    public AgencyNotFoundException(Long tourId) {
        this.agencyId = tourId;
    }



    @Override
    public String getMessage() {
        return "Agency with ID " + agencyId + " could not be found";
    }



    @Override
    public List<SourceLocation> getLocations() {
        return null;
    }



    @Override
    public Map<String, Object> getExtensions() {
        return Collections.singletonMap("agencyId", agencyId);
    }



    @Override
    public ErrorType getErrorType() {
        return ErrorType.DataFetchingException;
    }
}
