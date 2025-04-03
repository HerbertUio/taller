package com.uab.taller.store.controller;


import com.uab.taller.store.domain.User;
import com.uab.taller.store.domain.dto.request.UserRequest;
import com.uab.taller.store.service.IUserService;
import com.uab.taller.store.usecase.CreateUserUseCase;
import com.uab.taller.store.usecase.GetUserUseCase;
import com.uab.taller.store.usecase.GetUsersUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class  UserController {

    @Autowired
    IUserService userService;
    @Autowired
    GetUserUseCase getUserUseCase;
    @Autowired
    GetUsersUseCase getUsersUseCase;
    @Autowired
    CreateUserUseCase createUserUseCase;

    @GetMapping()
    public List<User> getAll(){
        return getUsersUseCase.getAll();
    }
    @GetMapping(value = "/getbyid/{id}")
    public User getById(@PathVariable Long id)
    {
        return getUserUseCase.getById(id).orElse(null);
    }
    @DeleteMapping(value = "deletebyid/{id}")
    public void delete (@PathVariable Long id){
        userService.deleteById(id);
    }
    @PostMapping (value = "/save")
    public User save(@RequestBody UserRequest userRequest){
        User user = new User();
        user.setName(userRequest.getName());
        user.setLastName(userRequest.getLastName());
        user.setEmail(userRequest.getEmail());
        user.setPassword(userRequest.getPassword());
        return createUserUseCase.createUser(user);
    }

}
