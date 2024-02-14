package com.sportsapppoc.events.Events.Service.ServiceImpl;

import com.sportsapppoc.events.Events.DTO.EventDTO;
import com.sportsapppoc.events.Events.DTO.EventResponse;
import com.sportsapppoc.events.Events.DTO.ProfileDTO;
import com.sportsapppoc.events.Events.DTO.ProfileIdRequest;
import com.sportsapppoc.events.Events.Entity.Events;
import com.sportsapppoc.events.Events.Exception.ResourceNotFoundException;
import com.sportsapppoc.events.Events.Repository.EventRepo;
import com.sportsapppoc.events.Events.Service.Client.ProfileFeignClient;
import com.sportsapppoc.events.Events.Service.EventService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class EventServiceImpl implements EventService {
    private final EventRepo eventRepo;
    private  final ProfileFeignClient profileFeignClient;
    private static final Logger log = LoggerFactory.getLogger(EventServiceImpl.class);
    private final StreamBridge streamBridge;

    @Override
    public EventResponse createEvent(EventDTO eventDTO) {
        Events events = eventsDtoToEvent(eventDTO);
        Events savedEvent = eventRepo.save(events);
        sendCommunication(savedEvent.getMobileNumber());
        return eventToEventResponse(savedEvent);
    }
    private void sendCommunication(String mobileNumber) {
        log.info("Sending Communication request for the details: {}",mobileNumber);
        var result = streamBridge.send("sendCommunication-out-0", mobileNumber);
        log.info("Is the Communication request successfully triggered ? : {}", result);
    }

    @Override
    public EventResponse updateEvent(EventDTO eventDTO, Integer id) {
        Events events = eventRepo.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Event","eventId",id));
        events.setEventTime(eventDTO.getEventTime());
        events.setLatitude(eventDTO.getLatitude());
        events.setLongitude(eventDTO.getLongitude());
        events.setImageUrl(eventDTO.getImageUrl());
        events.setSportsName(eventDTO.getSportsName());
        Events updatedEvent = eventRepo.save(events);
        return eventToEventResponse(updatedEvent);
    }

    @Override
    public void deleteEvent(Integer id) {
        Events events = eventRepo.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Event","eventId",id));
        eventRepo.delete(events);
    }

    @Override
    public List<EventResponse> getAllEvents() {
        List<Events> events = eventRepo.findAll();
        List<EventResponse> eventResponses = events.stream().map(events1 -> eventToEventResponse(events1)).collect(Collectors.toList());
        return eventResponses;
    }

    private Events eventsDtoToEvent(EventDTO eventDTO){
        Events events = new Events();
        events.setEventTime(eventDTO.getEventTime());
        events.setEventCreatedTime(LocalDateTime.now());
        events.setLatitude(eventDTO.getLatitude());
        events.setLongitude(eventDTO.getLongitude());
        events.setImageUrl(eventDTO.getImageUrl());
        events.setSportsName(eventDTO.getSportsName());
        events.setMobileNumber(eventDTO.getMobileNumber());
        return events;
    }
    private EventResponse eventToEventResponse(Events events){
        EventResponse eventResponse = new EventResponse();
        eventResponse.setEventTime(events.getEventTime());
        eventResponse.setLongitude(events.getLongitude());
        eventResponse.setLatitude(events.getLatitude());
        eventResponse.setEventCreatedTime(events.getEventCreatedTime());
        eventResponse.setImageUrl(events.getImageUrl());
        eventResponse.setSportsName(events.getSportsName());
        ProfileIdRequest profileIdRequest = new ProfileIdRequest(events.getMobileNumber());
        ProfileDTO profileDTO = profileFeignClient.getById(profileIdRequest).getBody();
        eventResponse.setProfileDTO(profileDTO);
        return eventResponse;
    }
}
