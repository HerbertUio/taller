package com.uab.taller.store.usecase;

import com.uab.taller.store.domain.User;
import com.uab.taller.store.domain.dto.request.UserRequest;
import com.uab.taller.store.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateUserUseCase {
    @Autowired
    IUserService userService;

    public User createUser(UserRequest userRequest) {
        User user = new User();
        user.setName(userRequest.getName());
        user.setLastName(userRequest.getLastName());
        user.setEmail(userRequest.getEmail());
        user.setPassword(userRequest.getPassword());
        return userService.save(user);
    }
}
