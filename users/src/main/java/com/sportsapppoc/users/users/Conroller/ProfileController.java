package com.sportsapppoc.users.users.Conroller;

import com.sportsapppoc.users.users.DTO.ErrorResponse;
import com.sportsapppoc.users.users.DTO.ProfileDTO;
import com.sportsapppoc.users.users.DTO.ProfileIdRequest;
import com.sportsapppoc.users.users.DTO.SuccessResponse;
import com.sportsapppoc.users.users.Service.ProfileService;
import io.github.resilience4j.retry.annotation.Retry;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Logger;

@RestController
@RequestMapping("/profile")
@RequiredArgsConstructor
public class ProfileController {
    private final ProfileService profileService;
    @Operation(
            summary = "Create Profile REST API",
            description = "REST API to create Profile in Sports App"
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
    @PostMapping("/create")
    public ResponseEntity<SuccessResponse> createProfile(@Valid @RequestBody ProfileDTO profileDTO){
        profileService.createProfile(profileDTO);
        return new ResponseEntity<>
                (new SuccessResponse("Profile Created Successfully",true), HttpStatus.CREATED);
    }
    @Operation(
            summary = "Update Profile REST API",
            description = "REST API to update Profile in Sports App"
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
    @PutMapping("/update")
    public ResponseEntity<SuccessResponse> updateProfile(@Valid @RequestBody ProfileDTO profileDTO){
        profileService.updateProfile(profileDTO);
        return new ResponseEntity<>
                (new SuccessResponse("Profile Updated Successfully",true),HttpStatus.OK);
    }
    @Operation(
            summary = "Get Profile Details By MobileNumber REST API",
            description = "REST API to fetch Profile using mobileNumber in Sports App"
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
    @PostMapping("/getById")
    public ResponseEntity<ProfileDTO> getById(@Valid @RequestBody ProfileIdRequest profileIdRequest){
        ProfileDTO profileDTO = profileService.getProfileById(profileIdRequest.getMobileNumber());
        return new ResponseEntity<>
                (profileDTO,HttpStatus.OK);
    }
    @Operation(
            summary = "Delete Profile By MobileNumber REST API",
            description = "REST API to delete Profile using mobileNumber in Sports App"
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
    @DeleteMapping("/deleteById")
    public ResponseEntity<SuccessResponse> deleteById(@Valid @RequestBody ProfileIdRequest profileIdRequest){
        profileService.deleteProfile(profileIdRequest.getMobileNumber());
        return new ResponseEntity<>
                (new SuccessResponse("Profile Deleted Successfully",true),HttpStatus.OK);
    }
}
