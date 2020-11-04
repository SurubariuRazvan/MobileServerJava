package com.mobile.services;

import com.mobile.domain.model.Account;
import com.mobile.domain.model.Authority;
import com.mobile.domain.model.exceptions.AccountAlreadyExistsException;
import com.mobile.domain.model.exceptions.NoValidAuthorityException;
import com.mobile.repositories.AccountRepository;
import com.mobile.repositories.AuthorityRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccountServiceImpl implements AccountService {

    private final AccountRepository   accountRepository;
    private final AuthorityRepository authorityRepository;

    public AccountServiceImpl(AccountRepository accountRepository, AuthorityRepository authorityRepository) {
        this.accountRepository = accountRepository;
        this.authorityRepository = authorityRepository;
    }

    @Override
    public Account saveAccount(Account account) {
        account.setId(0);
        List<Authority> authorities = authorityRepository.findByNameIn(account.getAuthorities()
                .stream()
                .map(Authority::getName)
                .collect(Collectors.toList()));

        if(authorities.isEmpty()) {
            throw new NoValidAuthorityException("None of the given authorities is valid");
        }

        if(accountRepository.findByUsername(account.getUsername()).isPresent()) {
            throw new AccountAlreadyExistsException("A user with the given username already exists.");
        }

        account.setAuthorities(authorities);
        return accountRepository.save(account);
    }
}
