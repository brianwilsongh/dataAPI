package com.brianapi.demo.repositories;

import com.brianapi.demo.entities.EventData;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventDataRepository extends CrudRepository<EventData, Long>{
    List<EventData> findByMillisSinceEpoch(long millis_since_epoch);
}
