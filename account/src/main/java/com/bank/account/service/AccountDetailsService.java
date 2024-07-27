package com.bank.account.service;

import com.bank.account.dto.AccountDetailsDto;
import com.bank.account.entity.AccountDetails;


import java.util.List;

public interface AccountDetailsService {
    AccountDetails findById(Long id);

    List<AccountDetails> findAll();

    void   save(AccountDetails accountDetails);

    void   update(Long id, AccountDetails accountDetails);

    void   delete(Long id);

}