package com.uab.taller.store.controller;

import com.uab.taller.store.domain.Account;
import com.uab.taller.store.domain.dto.request.AccountRequest;
import com.uab.taller.store.service.IAccountService;
import com.uab.taller.store.usecase.CreateAccountUseCase;
import com.uab.taller.store.usecase.GetAccountUseCase;
import com.uab.taller.store.usecase.GetAccountsUseCase;
import com.uab.taller.store.usecase.UpdateAccountUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/account")
public class AccountController {
    @Autowired
    IAccountService accountService;
    @Autowired
    GetAccountUseCase getAccountUseCase;
    @Autowired
    GetAccountsUseCase getAccountsUseCase;
    @Autowired
    CreateAccountUseCase createAccountUseCase;
    @Autowired
    UpdateAccountUseCase updateAccountUseCase;

    @GetMapping
    public List<Account> getAll() {
        return getAccountsUseCase.getAll();
    }
    @GetMapping(value = "/getbyid/{id}")
    public Account getById (@PathVariable Long id) {
        return getAccountUseCase.getById(id).orElse(null);
    }

    @PostMapping(value = "/save")
    public Account save(@RequestBody Account account) {
        return createAccountUseCase.createAccount(account);
    }
    @PutMapping(value = "/update/{id}")
    public Account update(@PathVariable Long id, @RequestBody AccountRequest account) {
        return updateAccountUseCase.updateAccount(id, account);
    }
    @DeleteMapping(value = "deletebyid/{id}")
    public void delete(@PathVariable Long id) {
        accountService.deleteById(id);
    }

}
