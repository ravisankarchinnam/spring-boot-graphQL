package com.github.ravisankarchinnam.tours.graphql.input;

import com.github.ravisankarchinnam.tours.enums.TourType;
import lombok.*;
import org.springframework.beans.factory.annotation.Value;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class UpdateTourInput {

    private Long id;

    private String name;

    private String price;

    private String duration;

    private String description;

    private TourType type;

    private Long agency;

}