package com.github.ravisankarchinnam.tours.dto;

public class TourDTO {

    private String name;

    private String price;

    private String duration;

    private String description;

    private String type;

    private Long agencyId;



    public String getName() {
        return name;
    }



    public void setName(String pName) {
        name = pName;
    }



    public String getPrice() {
        return price;
    }



    public void setPrice(String pPrice) {
        price = pPrice;
    }



    public String getDuration() {
        return duration;
    }



    public void setDuration(String pDuration) {
        duration = pDuration;
    }



    public String getDescription() {
        return description;
    }



    public void setDescription(String pDescription) {
        description = pDescription;
    }



    public String getType() {
        return type;
    }



    public void setType(String pType) {
        type = pType;
    }



    public Long getAgencyId() {
        return agencyId;
    }



    public void setAgencyId(Long pAgencyId) {
        agencyId = pAgencyId;
    }



    @Override
    public String toString() {
        return "TourDTO{" +
                "name='" + name + '\'' +
                ", price='" + price + '\'' +
                ", duration='" + duration + '\'' +
                ", description='" + description + '\'' +
                ", type='" + type + '\'' +
                ", agencyId='" + agencyId + '\'' +
                '}';
    }
}
