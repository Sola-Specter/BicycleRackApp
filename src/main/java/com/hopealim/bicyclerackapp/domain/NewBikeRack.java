package com.hopealim.bicyclerackapp.domain;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


@Getter
@Setter
@ToString
@Entity
@Table(name = "new_bike_rack")
public class NewBikeRack  {

    @Id

    @Column(name = "ID")
    private int id;
    @Column(name = "ADD_FULL")
    @NotNull(message = "Address Field Cannot be Blank")
    private String address;
    @Column(name = "POSTAL_CDE")
    @NotNull(message = "Postal_Code Field Cannot be Blank")
    private String postalCode;
    @Column(name = "CITY")
    @NotNull(message = "City Field Cannot be Blank")
    private String city;
    @NotNull(message = "Longitude Field Cannot be Blank")
    @Column(name = "LONGITUDE")
    private double longitude;
    @NotNull(message = "Latitude Field Cannot be Blank")
    @Column(name = "LATITUDE")
    private double latitude;
    @NotNull(message = "Capacity Field Cannot be Blank")
    @Column(name = "CAPACITY")
    private String capacity;
    @NotNull(message = "MultiModal Field Cannot be Blank")
    @Column(name = "MULTIMODAL")
    private String multiModal;
    @NotNull(message = "Seasonal Field Cannot be Blank")
    @Column(name = "SEASONAL")
    private String seasonal;
    @NotNull(message = "Sheltered Field Cannot be Blank")
    @Column(name = "SHELTERED")
    private String sheltered;
    @NotNull(message = "Surface Field Cannot be Blank")
    @Column(name = "SURFACE")
    private String surface;
    @NotNull(message = "Status Field Cannot be Blank")
    @Column(name = "STATUS")
    private String status;
    @NotNull(message = "Notes Field Cannot be Blank")
    @Column(name = "NOTES")
    private String notes;
    @NotNull(message = "MapClass Field Cannot be Blank")
    @Column(name = "MAP_CLASS")
    private String mapClass;
    @Column(name = "COUNT")
    private int count;
    @Column(name = "PUSH_STATUS")
    private String pushStatus;
}
