package com.uab.taller.store.usecase;

import com.uab.taller.store.domain.Profile;
import com.uab.taller.store.service.IProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateProfileUseCase {
    @Autowired
    IProfileService profileService;

    public Profile createProfile(Profile profile) {
        return profileService.save(profile);
    }

}

