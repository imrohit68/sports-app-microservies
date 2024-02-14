package com.sportsapppoc.users.users.Service;

import com.sportsapppoc.users.users.DTO.ProfileDTO;

import java.util.List;

public interface ProfileService {
    ProfileDTO createProfile(ProfileDTO profile);
    ProfileDTO updateProfile(ProfileDTO profile);
    ProfileDTO getProfileById(String id);
    void deleteProfile(String id);
}
