package com.uab.taller.store.usecase;

import com.uab.taller.store.domain.User;
import com.uab.taller.store.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@Service
public class GetUserUseCase {
    @Autowired
    IUserService userService;

    public Optional<User> getById(@PathVariable Long id)
    {
        return Optional.ofNullable(userService.getById(id));
    }
}
