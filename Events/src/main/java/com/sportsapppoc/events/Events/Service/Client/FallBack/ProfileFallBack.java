package com.sportsapppoc.events.Events.Service.Client.FallBack;

import com.sportsapppoc.events.Events.DTO.ProfileDTO;
import com.sportsapppoc.events.Events.DTO.ProfileIdRequest;
import com.sportsapppoc.events.Events.Exception.FeignClientException;
import com.sportsapppoc.events.Events.Service.Client.ProfileFeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class ProfileFallBack implements ProfileFeignClient {
    @Override
    public ResponseEntity<ProfileDTO> getById(ProfileIdRequest profileIdRequest) {
        throw new FeignClientException("Profile Service is not Responding");
    }
}
