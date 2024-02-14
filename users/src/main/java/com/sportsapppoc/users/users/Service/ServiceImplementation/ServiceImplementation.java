package com.sportsapppoc.users.users.Service.ServiceImplementation;

import com.sportsapppoc.users.users.DTO.ProfileDTO;
import com.sportsapppoc.users.users.Entity.Profile;
import com.sportsapppoc.users.users.Exception.ResourceNotFoundException;
import com.sportsapppoc.users.users.Respository.ProfilesRepo;
import com.sportsapppoc.users.users.Service.ProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ServiceImplementation implements ProfileService {
    private final ProfilesRepo profilesRepo;
    @Override
    public ProfileDTO createProfile(ProfileDTO profile) {
        Profile profile1 = modelMapperProfile(profile);
        Profile savedProfile = profilesRepo.save(profile1);
        return modelMapperProfileDTO(savedProfile);
    }

    @Override
    public ProfileDTO updateProfile(ProfileDTO profile) {
        Profile findProfile = profilesRepo.findById(profile.getMobileNumber())
                .orElseThrow(()->new ResourceNotFoundException("Profile","mobileNumber",profile.getMobileNumber()));
        findProfile.setName(profile.getName());
        Profile updated = profilesRepo.save(findProfile);
        return modelMapperProfileDTO(updated);
    }

    @Override
    public ProfileDTO getProfileById(String id) {
        Profile profile = profilesRepo.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Profile","mobileNumber",id));
        return modelMapperProfileDTO(profile);
    }

    @Override
    public void deleteProfile(String id) {
        Profile profile = profilesRepo.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException("Profile","mobileNumber",id));
        profilesRepo.delete(profile);
    }
    public Profile modelMapperProfile(ProfileDTO profileDTO){
        Profile profile = new Profile(profileDTO.getMobileNumber(),profileDTO.getName());
        return profile;
    }
    public ProfileDTO modelMapperProfileDTO(Profile profile){
        ProfileDTO profileDTO = new ProfileDTO(profile.getMobileNumber(), profile.getName());
        return profileDTO;
    }
}
