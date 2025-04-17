package com.uab.taller.store.usecase;

import com.uab.taller.store.domain.Profile;
import com.uab.taller.store.service.IProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GetProfileUseCase {
    @Autowired
    IProfileService profileService;

    public Optional<Profile> getById(Long id)
    {
        return Optional.ofNullable(profileService.getById(id));
    }
}
