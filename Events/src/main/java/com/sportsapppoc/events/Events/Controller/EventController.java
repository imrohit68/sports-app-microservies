package com.sportsapppoc.events.Events.Controller;

import com.sportsapppoc.events.Events.DTO.ErrorResponse;
import com.sportsapppoc.events.Events.DTO.EventDTO;
import com.sportsapppoc.events.Events.DTO.EventResponse;
import com.sportsapppoc.events.Events.DTO.SuccessResponse;
import com.sportsapppoc.events.Events.Service.EventService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/event")
@RequiredArgsConstructor
public class EventController {
    private final EventService eventService;
    private static final Logger logger = LoggerFactory.getLogger(EventController.class);
    @PostMapping("/create")
    @Operation(
            summary = "Create Event REST API",
            description = "REST API to create event in Sports App"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "201",
                    description = "HTTP Status OK",
                    content = @Content(
                            schema = @Schema(implementation = SuccessResponse.class)
                    )
            ),
            @ApiResponse(
                    responseCode = "401",
                    description = "HTTP BAD_REQUEST Error",
                    content = @Content(
                            schema = @Schema(implementation = ErrorResponse.class)
                    )
            )
    }
    )
    public ResponseEntity<SuccessResponse> createEvent(@Valid @RequestBody EventDTO eventDTO){
        EventResponse eventResponse = eventService.createEvent(eventDTO);
        return new ResponseEntity<>(new SuccessResponse("Event Created Successfully",true), HttpStatus.CREATED);
    }
    @PutMapping("/update/{id}")
    @Operation(
            summary = "Update Event REST API",
            description = "REST API to update event in sports app"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "HTTP Status OK",
                    content = @Content(
                            schema = @Schema(implementation = SuccessResponse.class)
                    )
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "HTTP NOT_FOUND Error",
                    content = @Content(
                            schema = @Schema(implementation = ErrorResponse.class)
                    )
            )
    }
    )
    public ResponseEntity<SuccessResponse> updateEvent(@Valid @RequestBody EventDTO eventDTO,@PathVariable int id){
        EventResponse eventResponse = eventService.updateEvent(eventDTO,id);
        return new ResponseEntity<>(new SuccessResponse("Event Updated Successfully",true),HttpStatus.OK);
    }
    @Operation(
            summary = "Delete Event REST API",
            description = "REST API to delete a event in Sports App"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "HTTP Status OK",
                    content = @Content(
                            schema = @Schema(implementation = SuccessResponse.class)
                    )
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "HTTP NOT_FOUND Error",
                    content = @Content(
                            schema = @Schema(implementation = ErrorResponse.class)
                    )
            )
    }
    )
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<SuccessResponse> deleteById(@PathVariable int id){
        eventService.deleteEvent(id);
        return new ResponseEntity<>(new SuccessResponse("Event Deleted Successfully",true),HttpStatus.OK);
    }
    @GetMapping("/getAllEvents")
    @Operation(
            summary = "Get All the Events",
            description = "REST API to get all events in Sports App"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "HTTP Status OK",
                    content = @Content(
                            schema = @Schema(implementation = EventResponse.class)
                    )
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "HTTP NOT_FOUND Error",
                    content = @Content(
                            schema = @Schema(implementation = ErrorResponse.class)
                    )
            )
    }
    )
    public ResponseEntity<List<EventResponse>> getAllEvents(){
        logger.debug("Get Events method start");
        return new ResponseEntity<>(eventService.getAllEvents(),HttpStatus.OK);
    }
}
