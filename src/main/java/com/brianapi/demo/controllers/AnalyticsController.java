package com.brianapi.demo.controllers;


import com.brianapi.demo.entities.EventData;
import com.brianapi.demo.entities.TimestampData;
import com.brianapi.demo.repositories.EventDataRepository;
import com.brianapi.demo.services.EventDataService;
import com.brianapi.demo.utils.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.*;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.ValidatorFactory;
import java.util.Set;

@RestController
@RequestMapping("/analytics")
public class AnalyticsController {

    @Autowired
    EventDataService eventDataService;

    @PostMapping
    ResponseEntity<?> createEventHandler(@RequestParam Long timestamp,
                                         @RequestParam Long user,
                                         @RequestParam String event){

        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        javax.validation.Validator validator = factory.getValidator();

        EventData eventData = new EventData(timestamp, user, event);
        Set<ConstraintViolation<EventData>> violations = validator.validate(eventData);
        if (violations.size() > 0){
            //for (ConstraintViolation<EventData> violation : violations){
//            System.out.println("violation:");
//            System.out.println(violation.getMessage());
//        }
            return ResponseEntity.badRequest().build();
        }
        System.out.println("new data: " + eventData.toString());
        eventDataService.save(eventData);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    ResponseEntity<TimestampData> fetchEventHandler(@RequestParam Long timestamp){
        System.out.println("GET endpoint received with Query param:" + timestamp);
        TimestampData timestampData = eventDataService.getDataByTimestamp(timestamp);
        if (timestampData == null){
            //TODO: add a validator and check against contstraints as well
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.accepted().body(timestampData);
    }

}
