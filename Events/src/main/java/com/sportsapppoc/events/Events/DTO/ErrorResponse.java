package com.sportsapppoc.events.Events.DTO;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Schema(
        name = "Error Response for REST APIs"
)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ErrorResponse {
    @Schema(
             description = "Message of the Error",
            example = "xyz example error occurred"
    )
    private String message;
    @Schema(
            description = "Status of the Request",
            example = "false"
    )
    private boolean status;
}
