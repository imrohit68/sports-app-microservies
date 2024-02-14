package com.sportsapppoc.users.users.DTO;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Schema(
        name = "Profile",
        description = "Schema to hold profile information"
)
public class ProfileDTO {
    @NotEmpty(message = "Mobile Number can not be a null or empty")
    @Pattern(regexp="(^$|[0-9]{10})",message = "Mobile Number must be 10 digits")
    @Schema(
            description = "Mobile Number for the Profile",
            example = "9162412413"
    )
    private String mobileNumber;
    @NotEmpty(message = "Name can not be a null or empty")
    @Size(min = 3 , message = "Name cannot be less than three characters" )
    @Schema(
            description = "Name of the Profile",
            example = "Rohit Singh"
    )
    private String name;
}
