package com.uab.taller.store.usecase;

import com.uab.taller.store.domain.Account;
import com.uab.taller.store.service.IAccountService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GetAccountUseCase {
    IAccountService accountService;
    public Optional<Account> getById(Long id)
    {
        return Optional.ofNullable(accountService.getById(id));
    }

}
