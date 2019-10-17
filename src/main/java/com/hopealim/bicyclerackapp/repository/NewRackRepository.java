package com.hopealim.bicyclerackapp.repository;

import com.hopealim.bicyclerackapp.domain.NewBikeRack;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface NewRackRepository extends JpaRepository<NewBikeRack, Integer> {

    NewBikeRack findAllByLatitudeAndLongitudeAndPostalCode(double latitude, double longitude, String postalCode);

    @Modifying
    @Query("update NewBikeRack c set c.count = ?1 where c.id = ?2")
    int updateNewRackCount(int count, int id);

    @Modifying
    @Query("update NewBikeRack c set c.pushStatus = ?2 where c.id = ?1")
    int updatePushStatus(int id, String message);

}
