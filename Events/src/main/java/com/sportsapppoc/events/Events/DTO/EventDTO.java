package com.sportsapppoc.events.Events.DTO;

import com.sportsapppoc.events.Events.Enum.SportsCategories;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.time.LocalDateTime;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Schema(name = "Event DTO for REST APIs")
public class EventDTO {
    @Schema(
            description = "Date and Time of the Event",
            example = "yyyy-MM-dd HH:mm:ss"
    )
    @NotNull(message = "Event time cannot be null or empty")
    private LocalDateTime eventTime;
    @NotEmpty(message = "Mobile Number can not be a null or empty")
    @Pattern(regexp="(^$|[0-9]{10})",message = "Mobile Number must be 10 digits")
    @Schema(
            description = "Mobile Number of the event owner",
            example = "9162412413"
    )
    private String mobileNumber;
    @Schema(
            description = "Image url of the Event",
            example = "xyz.com"
    )
    private String imageUrl;
    @Schema(
            description = "Sports Category of the Event",
            example = "CRICKET"
    )
    @NotNull(message = "Sports category cannot be null of the event")
    private SportsCategories sportsName;
    @Schema(
            description = "Latitude of the location of the Event",
            example = "18.457335586712336"
    )
    @NotEmpty(message = "The location latitude of the event cannot be empty")
    private String latitude;
    @Schema(
            description = "Longitude of the location of the Event",
            example = "73.85295870582583"
    )
    @NotEmpty(message = "The location longitude of the event cannot be empty")
    @NotEmpty()
    private String longitude;
}
