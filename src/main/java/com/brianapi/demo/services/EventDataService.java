package com.brianapi.demo.services;

import com.brianapi.demo.entities.EventData;
import com.brianapi.demo.entities.TimestampData;
import com.brianapi.demo.repositories.EventDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Service
public class EventDataService {

    @Autowired
    EventDataRepository eventDataRepository;


    public void save(EventData eventData){
        eventDataRepository.save(eventData);
    }

    public TimestampData getDataByTimestamp(Long timestamp){
        //TODO: find way to cache results of older timestamps
        List<EventData> eventsInTimestamp = eventDataRepository.findByMillisSinceEpoch(timestamp); //UNIX time, assume GMT
        Set<Long> userIds = new HashSet<>();
        int clicks = 0;
        int impressions = 0;
        for (EventData eventData : eventsInTimestamp){
            userIds.add(eventData.getUser_id());
            clicks += eventData.getEvent().equals("click") ? 1 : 0;
            impressions += eventData.getEvent().equals("impression") ? 1 : 0;
        }
        return new TimestampData(timestamp, userIds.size(), clicks, impressions);

    }
}
