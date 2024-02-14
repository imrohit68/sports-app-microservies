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
@Schema(
        name = "Success Response for Rest APIs"
)
public class SuccessResponse {
    @Schema(
            description = "Success Message",
            example = "XYZ request completed"
    )
    private String message;
    @Schema(
            description = "Status of request",
            example = "true"
    )
    private boolean status;
}
