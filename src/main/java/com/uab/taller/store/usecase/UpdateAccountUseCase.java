package com.uab.taller.store.usecase;

import com.uab.taller.store.domain.Account;
import com.uab.taller.store.domain.dto.request.AccountRequest;
import com.uab.taller.store.service.IAccountService;
import org.springframework.stereotype.Service;

@Service
public class UpdateAccountUseCase {
    IAccountService accountService;
    public Account updateAccount(Long id, AccountRequest accountRequest) {
        Account accountToUpdate = accountService.getById(id);
        if (accountToUpdate != null) {
            accountToUpdate.setNumber(accountRequest.getNumber());
            accountToUpdate.setSalary(accountRequest.getSalary());
            accountToUpdate.setType(accountRequest.getType());
            return accountService.save(accountToUpdate);

        }
        return null;
    }

}
