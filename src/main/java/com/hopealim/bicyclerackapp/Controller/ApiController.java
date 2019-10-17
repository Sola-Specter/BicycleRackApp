package com.hopealim.bicyclerackapp.Controller;

import com.hopealim.bicyclerackapp.domain.BicycleParkingRack;
import com.hopealim.bicyclerackapp.domain.NewBikeRack;
import com.hopealim.bicyclerackapp.services.BicycleRackInfoService;
import com.hopealim.bicyclerackapp.services.NewBikeRackService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.net.Inet4Address;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/api")
public class ApiController {
    private static final Logger logger = LoggerFactory.getLogger(ApiController.class);

    @Autowired
    BicycleRackInfoService bicycleRackInfoService;

    @Autowired
    NewBikeRackService newBikeRackService;

    @GetMapping("allBicycleRacks")
    public List<BicycleParkingRack> findAllRacks(HttpServletRequest request, Inet4Address address) {
        logger.info("");
        logger.info("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        logger.info("Call Time: {}", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime()));
        logger.info("Caller IP Address: {}", request.getRemoteAddr());
        logger.info("Service Called: {}", request.getRequestURI().toString());
        logger.info("Service Response: {}", bicycleRackInfoService.findAllRacks());
        logger.info("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");

        return bicycleRackInfoService.findAllRacks();
    }

    @PostMapping("addNewBicycleRack")
    public ResponseEntity<Map<String, Object>> addNewRack(@RequestBody NewBikeRack newBikeRack, HttpServletRequest request) {

        Map<String, Object> model = new HashMap<>();

        NewBikeRack isExist = newBikeRackService.isExist(newBikeRack.getLatitude(), newBikeRack.getLongitude(), newBikeRack.getPostalCode());

        if (isExist != null && isExist.getCount() < 10) {


            newBikeRackService.updateCount(isExist);
            model.put("message", "Count Updated");
            model.put("messageCode", 222);
            model.put("statusCode", HttpStatus.OK);

            logger.info("");
            logger.info("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
            logger.info("Call Time: {}", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime()));
            logger.info("PayLoad: {}", newBikeRack);
            logger.info("Caller IP Address: {}", request.getRemoteAddr());
            logger.info("Service Called: {}", request.getRequestURI().toString());
            logger.info("Response: {}", model);
            logger.info("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");


            return new ResponseEntity<>(model, HttpStatus.OK);

        } else if (isExist == null) {

            newBikeRackService.addNewBikeRack(newBikeRack);
            model.put("message", "New location has been added");
            model.put("messageCode", 111);
            model.put("statusCode", HttpStatus.OK);

            logger.info("");
            logger.info("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
            logger.info("Call Time: {}", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime()));
            logger.info("PayLoad: {}", newBikeRack);
            logger.info("Caller IP Address: {}", request.getRemoteAddr());
            logger.info("Service Called: {}", request.getRequestURI().toString());
            logger.info("Response: {}", model);
            logger.info("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");


            return new ResponseEntity<>(model, HttpStatus.OK);

        } else if (isExist.getCount() >= 10 && isExist.getPushStatus().equals("")) {

            BicycleParkingRack bicycleParkingRack = new BicycleParkingRack();

            bicycleParkingRack.setAddress(isExist.getAddress());
            bicycleParkingRack.setCapacity(isExist.getCapacity());
            bicycleParkingRack.setCity(isExist.getCity());
            bicycleParkingRack.setId(isExist.getId());
            bicycleParkingRack.setLatitude(isExist.getLatitude());
            bicycleParkingRack.setLongitude(isExist.getLongitude());
            bicycleParkingRack.setMapClass(isExist.getMapClass());
            bicycleParkingRack.setMultiModal(isExist.getMultiModal());
            bicycleParkingRack.setNotes(isExist.getNotes());
            bicycleParkingRack.setPostalCode(isExist.getPostalCode());
            bicycleParkingRack.setSeasonal(isExist.getSeasonal());
            bicycleParkingRack.setSheltered(isExist.getSheltered());
            bicycleParkingRack.setStatus(isExist.getStatus());
            bicycleParkingRack.setSurface(isExist.getSurface());

            bicycleRackInfoService.addNewBikeRack(bicycleParkingRack);
            newBikeRackService.updatePushStatus(isExist.getId(), "FlushedToMain");

            model.put("message", "Record Updated on Main Location Table");
            model.put("messageCode", 333);
            model.put("statusCode", HttpStatus.OK);

            logger.info("");
            logger.info("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
            logger.info("Call Time: {}", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime()));
            logger.info("PayLoad: {}", newBikeRack);
            logger.info("Caller IP Address: {}", request.getRemoteAddr());
            logger.info("Service Called: {}", request.getRequestURI().toString());
            logger.info("Response: {}", model);
            logger.info("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");

            return new ResponseEntity<>(model, HttpStatus.OK);

        }

        model.put("message", "Location Already Exist");
        model.put("messageCode", 101);
        model.put("statusCode", HttpStatus.OK);

        logger.info("");
        logger.info("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        logger.info("Call Time: {}", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime()));
        logger.info("PayLoad: {}", newBikeRack);
        logger.info("Caller IP Address: {}", request.getRemoteAddr());
        logger.info("Service Called: {}", request.getRequestURI().toString());
        logger.info("Response: {}", model);
        logger.info("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");

        return new ResponseEntity<>(model, HttpStatus.OK);
    }


}
