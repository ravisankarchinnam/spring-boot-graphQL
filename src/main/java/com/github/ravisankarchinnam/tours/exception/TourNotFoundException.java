package com.github.ravisankarchinnam.tours.exception;

import graphql.ErrorType;
import graphql.GraphQLError;
import graphql.language.SourceLocation;

import java.util.Collections;
import java.util.List;
import java.util.Map;


public class TourNotFoundException extends RuntimeException implements GraphQLError {

    private Long tourId;



    public TourNotFoundException(Long tourId) {
        this.tourId = tourId;
    }



    @Override
    public String getMessage() {
        return "Tour with ID " + tourId + " could not be found";
    }



    @Override
    public List<SourceLocation> getLocations() {
        return null;
    }



    @Override
    public Map<String, Object> getExtensions() {
        return Collections.singletonMap("tourId", tourId);
    }



    @Override
    public ErrorType getErrorType() {
        return ErrorType.DataFetchingException;
    }
}
