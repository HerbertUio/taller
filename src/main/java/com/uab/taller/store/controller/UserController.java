package com.uab.taller.store.controller;


import com.uab.taller.store.domain.User;
import com.uab.taller.store.domain.dto.request.UserRequest;
import com.uab.taller.store.service.IUserService;
import com.uab.taller.store.usecase.CreateUserUseCase;
import com.uab.taller.store.usecase.GetUserUseCase;
import com.uab.taller.store.usecase.GetUsersUseCase;
import com.uab.taller.store.usecase.UpdateUserUseCase;
import org.hibernate.sql.Update;
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
    @Autowired
    UpdateUserUseCase UpdateUserUseCase;

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
        return createUserUseCase.createUser(userRequest);
    }
    @PutMapping(value = "/update/{id}")
    public User update(@PathVariable Long id, @RequestBody UserRequest userRequest){
        return UpdateUserUseCase.updateUser(id,userRequest);
    }

}
