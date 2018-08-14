package com.tours.packages.model;

import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
@Table(name = "TOUR_AGENCY")
@Entity
public class Agency {

    @Id
    @Column(name = "AGENCY_ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "AGENCY_NAME", nullable = false)
    private String name;

    @Column(name = "AGENCY_RATING", nullable = false)
    private Double rating;

}
