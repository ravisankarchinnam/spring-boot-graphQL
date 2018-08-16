package com.github.ravisankarchinnam.tours.graphql.input;

import com.github.ravisankarchinnam.tours.enums.TourType;
import lombok.*;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class CreateTourInput {

    private String name;

    private String price;

    private String duration;

    private String description;

    private TourType type;

    private Long agency;
}
