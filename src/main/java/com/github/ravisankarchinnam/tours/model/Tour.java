package com.github.ravisankarchinnam.tours.model;

import com.github.ravisankarchinnam.tours.enums.TourType;
import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
@Table(name = "TOUR")
@Entity
public class Tour {

    @Id
    @Column(name = "TOUR_ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "TOUR_NAME", nullable = false)
    private String name;

    @Column(name = "TOUR_PRICE", nullable = false)
    private String price;

    @Column(name = "TOUR_DURATION", nullable = false)
    private String duration;

    @Column(name = "TOUR_DESCRIPTION")
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(name = "TOUR_TYPE")
    private TourType type;

    @ManyToOne
    @JoinColumn(name = "AGENCY_ID",
            nullable = false)
    private Agency agency;

}
