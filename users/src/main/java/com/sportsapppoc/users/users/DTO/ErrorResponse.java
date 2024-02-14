package com.sportsapppoc.users.users.DTO;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Schema(
        name = "Error Response for Rest APIs"
)
public class ErrorResponse {
    @Schema(
            description = "Error Message",
            example = "XYZ Error"
    )
    private String error;
    @Schema(
            description = "Request Status",
            example = "false"
    )
    private boolean status;
}
