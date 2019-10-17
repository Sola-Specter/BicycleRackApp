package com.hopealim.bicyclerackapp.services;


import com.hopealim.bicyclerackapp.domain.BicycleParkingRack;
import com.hopealim.bicyclerackapp.domain.NewBikeRack;
import com.hopealim.bicyclerackapp.repository.BicycleRackInfoRepository;
import com.hopealim.bicyclerackapp.util.Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class BicycleRackInfoService {

    private static final Logger logger = LoggerFactory.getLogger(BicycleRackInfoService.class);


    @Autowired
    BicycleRackInfoRepository bicycleRackInfoRepository;

    public List<BicycleParkingRack> findAllRacks(){

        return bicycleRackInfoRepository.findAll();
    }

    public BicycleParkingRack addNewBikeRack(BicycleParkingRack bicycleParkingRack){
        return bicycleRackInfoRepository.save(bicycleParkingRack);
    }

    public BicycleParkingRack findRackById(int id){

        return bicycleRackInfoRepository.findById(id);
    }
}
