package com.sportsapppoc.users.users.DTO;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Schema(
        name = "Success Response for Rest APIs"
)
public class SuccessResponse {
    @Schema(
            name = "Success Message",
            example = "XYZ request completed"
    )
    private String message;
    @Schema(
            name = "Status of request",
            example = "true"
    )
    private boolean status;
}
