package com.bank.account.service;


import com.bank.account.entity.AccountDetails;
import com.bank.account.exeption.ExceptionReturner;
import com.bank.account.repository.AccountDetailsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AccountDetailsServiceImpl implements AccountDetailsService {


    private final AccountDetailsRepository repository;

    private final ExceptionReturner exceptionReturner;
    private  static final String  MESSAGE_PREFIX = "не найден аккаунт с id : ";

    @Override
    public AccountDetails findById(Long id) {
        return (repository.findById(id)
                .orElseThrow(() -> exceptionReturner.getEntityNotFoundException(MESSAGE_PREFIX + id))
        );
    }

    @Override
    public List<AccountDetails> findAll() {

        return repository.findAll();
    }

    @Override
    @Transactional
    public void  save(AccountDetails accountDetails) {
        repository.save(accountDetails);
    }

    @Override
    @Transactional
    public void  update(Long id, AccountDetails accountDetails) {
        accountDetails.setId(id);
        repository.save(accountDetails);
    }
    @Override
    @Transactional
    public void  delete(Long id) {
        repository.deleteById(id);
    }

}
