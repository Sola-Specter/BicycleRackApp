package com.hopealim.bicyclerackapp.services;

import com.hopealim.bicyclerackapp.domain.NewBikeRack;
import com.hopealim.bicyclerackapp.repository.NewRackRepository;
import com.hopealim.bicyclerackapp.util.Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class NewBikeRackService {
    private static final Logger logger = LoggerFactory.getLogger(NewBikeRackService.class);

    @Autowired
    NewRackRepository newRackRepository;

    public NewBikeRack addNewBikeRack(NewBikeRack newBikeRack) {
        newBikeRack.setId(Util.getUniqueId());
        newBikeRack.setCount(1);
        newBikeRack.setPushStatus("");
        return newRackRepository.save(newBikeRack);
    }

    public void updatePushStatus(int id, String message){
        newRackRepository.updatePushStatus(id, message);
    }

    public NewBikeRack isExist(double latitude, double longitude, String postalCode) {

        return newRackRepository.findAllByLatitudeAndLongitudeAndPostalCode(latitude, longitude, postalCode);

    }

    public void updateCount(NewBikeRack newBikeRack) {
        int count = newBikeRack.getCount() + 1;
        newRackRepository.updateNewRackCount(count, newBikeRack.getId());
    }
}
