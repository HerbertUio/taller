package com.uab.taller.store.controller;

import com.uab.taller.store.domain.Profile;
import com.uab.taller.store.domain.dto.request.ProfileRequest;
import com.uab.taller.store.service.IProfileService;
import com.uab.taller.store.usecase.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/profile")
public class ProfileController {
    @Autowired
    IProfileService profileService;
    @Autowired
    GetProfilesUseCase getProfilesUseCase;
    @Autowired
    GetProfileUseCase getProfileUseCase;
    @Autowired
    CreateProfileUseCase createProfileUseCase;
    @Autowired
    UpdateProfileUseCase updateProfileUseCase;
    @Autowired
    DeleteUserUseCase deleteUserUseCase;

    @GetMapping()
    public List<Profile> getAllProfiles() {
        return getProfilesUseCase.getAll();
    }
    @GetMapping(value = "/getbyid/{id}")
    public Profile getProfileById(@PathVariable Long id) {
        return getProfileUseCase.getById(id).orElse(null);
    }
    @PostMapping(value = "/save")
    public Profile save(@RequestBody ProfileRequest profile) {
        Profile newProfile = new Profile();
        newProfile.setName(profile.getName());
        newProfile.setLastName(profile.getLastName());
        newProfile.setBithDate(profile.getBirthDate());
        newProfile.setGender(profile.isGender());
        return createProfileUseCase.createProfile(newProfile);
    }
    @PostMapping(value = "/update/{id}")
    public ResponseEntity<Profile> updateProfile(@PathVariable Long id, @RequestBody ProfileRequest profile) {
        var existingProfile = getProfileUseCase.getById(id).orElse(null);

        if (existingProfile != null) {
            existingProfile.setName(profile.getName());
            existingProfile.setLastName(profile.getLastName());
            existingProfile.setBithDate(profile.getBirthDate());
            existingProfile.setGender(profile.isGender());

            var updatedProfile = updateProfileUseCase.updateProfile(existingProfile);
            return ResponseEntity.ok(updatedProfile);
        }

        return ResponseEntity.notFound().build();
    }
    @DeleteMapping(value = "/deletebyid/{id}")
    public void deleteProfile(@PathVariable Long id) {
        var existingProfile = getProfileUseCase.getById(id).orElse(null);
        deleteUserUseCase.deleteById(id);
    }
}
