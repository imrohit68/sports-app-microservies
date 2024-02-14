package com.sportsapppoc.events.Events.Service.Client;

import com.sportsapppoc.events.Events.DTO.ProfileDTO;
import com.sportsapppoc.events.Events.DTO.ProfileIdRequest;
import com.sportsapppoc.events.Events.Service.Client.FallBack.ProfileFallBack;
import jakarta.validation.Valid;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(value = "profile",fallback = ProfileFallBack.class)
@Service
public interface ProfileFeignClient {
    @PostMapping("/profile/getById")
    ResponseEntity<ProfileDTO> getById(@Valid @RequestBody ProfileIdRequest profileIdRequest);
}
