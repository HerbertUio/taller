package com.uab.taller.store.usecase;

import com.uab.taller.store.service.IAccountService;
import org.springframework.stereotype.Service;

@Service
public class DeleteAccountUseCase {
    IAccountService accountService;

    public void deleteById(Long id) {
        accountService.deleteById(id);
    }
}
