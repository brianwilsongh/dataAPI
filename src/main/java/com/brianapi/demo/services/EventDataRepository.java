package com.brianapi.demo.services;

import com.brianapi.demo.entities.EventData;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventDataRepository extends CrudRepository<EventData, Long>{
}
