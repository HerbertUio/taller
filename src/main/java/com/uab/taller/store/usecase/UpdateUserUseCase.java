package com.uab.taller.store.usecase;

import com.uab.taller.store.domain.User;
import com.uab.taller.store.domain.dto.request.UserRequest;
import com.uab.taller.store.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UpdateUserUseCase {
    @Autowired
    IUserService userService;
    public User updateUser(Long id,UserRequest userRequest) {
        User userToUpdate = userService.getById(id);
        if (userToUpdate != null) {
            userToUpdate.setName(userRequest.getName());
            userToUpdate.setLastName(userRequest.getLastName());
            userToUpdate.setEmail(userRequest.getEmail());
            userToUpdate.setPassword(userRequest.getPassword());
            return userService.save(userToUpdate);
        }
        return null;
    }
}
