package com.brianapi.demo.controllers;


import com.brianapi.demo.entities.EventData;
import com.brianapi.demo.services.EventDataRepository;
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
    EventDataRepository eventDataRepository;

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
        eventDataRepository.save(eventData);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    ResponseEntity<EventData> fetchEventHandler(@RequestParam Long timestamp){
        System.out.println("GET endpoint received with Query param:" + timestamp);
        EventData ed = eventDataRepository.findById(timestamp).get();
        return ResponseEntity.accepted().body(ed);
//        return null;
    }

}
