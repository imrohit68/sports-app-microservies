package com.sportsapppoc.events.Events.DTO;

import com.sportsapppoc.events.Events.Enum.SportsCategories;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Schema(
        name = "Event Response",
        description = "Event details Response for REST APIs"
)
public class EventResponse {
    @Schema(
            description = "Date and Time of the Event Created",
            example = "yyyy-MM-dd HH:mm:ss"
    )
    private LocalDateTime eventCreatedTime;
    @Schema(
            description = "Date and Time of the Event",
            example = "yyyy-MM-dd HH:mm:ss"
    )
    private LocalDateTime eventTime;
    @Schema(
            description = "Image url of the Event",
            example = "xyz.com"
    )
    private String imageUrl;
    @Schema(
            description = "Sports Category of the Event",
            example = "CRICKET"
    )
    private SportsCategories sportsName;
    @Schema(
            description = "Latitude of the location of the Event",
            example = "18.457335586712336"
    )
    private String latitude;
    @Schema(
            description = "Longitude of the location of the Event",
            example = "18.457335586712336"
    )
    private String longitude;
    @Schema(
            description = "Profile Info of the owner of the event",
            example = "18.457335586712336"
    )
    private ProfileDTO profileDTO;
}
