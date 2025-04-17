package com.uab.taller.store.usecase;

import com.uab.taller.store.domain.Account;
import com.uab.taller.store.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetAccountsUseCase {
    @Autowired
    IAccountService accountService;
    public List<Account> getAll() {
        return accountService.getAll();
    }

}
