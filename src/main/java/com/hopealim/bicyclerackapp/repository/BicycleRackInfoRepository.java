package com.hopealim.bicyclerackapp.repository;

import com.hopealim.bicyclerackapp.domain.BicycleParkingRack;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BicycleRackInfoRepository extends JpaRepository<BicycleParkingRack, Integer> {

    BicycleParkingRack findById(int id);

}
