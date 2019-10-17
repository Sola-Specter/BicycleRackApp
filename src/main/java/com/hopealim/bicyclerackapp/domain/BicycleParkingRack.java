package com.hopealim.bicyclerackapp.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@ToString
@Entity
@Table(name = "bicycle_parking_rack")
public class BicycleParkingRack {

    @Id
    @Column(name = "ID")
    private int id;
    @Column(name = "ADD_FULL")
    private String address;
    @Column(name = "POSTAL_CDE")
    private String postalCode;
    @Column(name = "CITY")
    private String city;
    @Column(name = "LONGITUDE")
    private double longitude;
    @Column(name = "LATITUDE")
    private double latitude;
    @Column(name = "CAPACITY")
    private String capacity;
    @Column(name = "MULTIMODAL")
    private String multiModal;
    @Column(name = "SEASONAL")
    private String seasonal;
    @Column(name = "SHELTERED")
    private String sheltered;
    @Column(name = "SURFACE")
    private String surface;
    @Column(name = "STATUS")
    private String status;
    @Column(name = "NOTES")
    private String notes;
    @Column(name = "MAP_CLASS")
    private String mapClass;
}
