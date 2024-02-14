package com.sportsapppoc.events.Events.Service;

import com.sportsapppoc.events.Events.DTO.EventDTO;
import com.sportsapppoc.events.Events.DTO.EventResponse;

import java.util.List;

public interface EventService {
    EventResponse createEvent(EventDTO eventDTO);
    EventResponse updateEvent(EventDTO eventDTO,Integer id);
    void deleteEvent(Integer id);
    List<EventResponse> getAllEvents();

}
