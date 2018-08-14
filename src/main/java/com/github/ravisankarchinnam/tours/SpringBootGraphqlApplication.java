package com.tours.packages;

import com.tours.packages.enums.TourType;
import com.tours.packages.exception.GraphQLErrorAdapter;
import com.tours.packages.model.Agency;
import com.tours.packages.model.Tour;
import com.tours.packages.repository.AgencyRepository;
import com.tours.packages.repository.TourRepository;
import graphql.ExceptionWhileDataFetching;
import graphql.GraphQLError;
import graphql.servlet.GraphQLErrorHandler;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
public class SpringBootGraphqlApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootGraphqlApplication.class, args);
    }



    @Bean
    public GraphQLErrorHandler errorHandler() {
        return new GraphQLErrorHandler() {
            @Override
            public List<GraphQLError> processErrors(List<GraphQLError> errors) {
                List<GraphQLError> clientErrors = errors.stream()
                        .filter(this::isClientError)
                        .collect(Collectors.toList());

                List<GraphQLError> serverErrors = errors.stream()
                        .filter(e -> !isClientError(e))
                        .map(GraphQLErrorAdapter::new)
                        .collect(Collectors.toList());

                List<GraphQLError> e = new ArrayList<>();
                e.addAll(clientErrors);
                e.addAll(serverErrors);
                return e;
            }



            protected boolean isClientError(GraphQLError error) {
                return !(error instanceof ExceptionWhileDataFetching || error instanceof Throwable);
            }
        };
    }



    @Bean
    public CommandLineRunner run(TourRepository tourRepository, AgencyRepository agencyRepository) {
        return (args) -> {
            Agency lAgency = new Agency(1L, "AtoZTours", 5d);
            agencyRepository.save(lAgency);
            Stream.of(
                    new Tour(1L, "Trondheim", "233", "2",
                            "Trondheim Kunstmuseum is an art museum located in Trondheim in Sør-Trøndelag county, Norway.", TourType.ECONOMY, lAgency),
                    new Tour(2L, "Nidaros Cathedral", "100", "1",
                            "Nidaros Cathedral is a Church of Norway cathedral located in the city of Trondheim in Trøndelag county, Norway", TourType.COUPLE, lAgency),
                    new Tour(3L, "Nidelva", "343", "2",
                            "Nidelva is a river in Trøndelag county, Norway. The 30-kilometre long river travels through the municipalities of Trondheim and Klæbu.", TourType.ADVENTURE, lAgency))
                    .forEach(tourRepository::save);
        };
    }

}
