package com.sportsapppoc.events.Events.DTO;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProfileDTO {
    @Schema(
            description = "Mobile Number for the Profile",
            example = "9162412413"
    )
    private String mobileNumber;
    @Schema(
            description = "Name of the Profile",
            example = "Rohit Singh"
    )
    private String name;
}
