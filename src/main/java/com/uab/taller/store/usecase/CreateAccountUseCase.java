package com.uab.taller.store.usecase;

import com.uab.taller.store.domain.Account;
import com.uab.taller.store.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateAccountUseCase {
    @Autowired
    IAccountService accountService;
    public Account createAccount(Account account) {
        Account accountCreated = new Account();
        accountCreated.setNumber(account.getNumber());
        accountCreated.setSalary(account.getSalary());
        accountCreated.setType(account.getType());
        return accountService.save(accountCreated);
    }
}
