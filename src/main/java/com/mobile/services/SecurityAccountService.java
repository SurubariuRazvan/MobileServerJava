package com.mobile.services;

import com.mobile.domain.model.Account;
import com.mobile.domain.model.SecurityAccount;
import com.mobile.repositories.AccountRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class SecurityAccountService implements UserDetailsService {

    private final AccountRepository accountRepository;

    public SecurityAccountService(AccountRepository AccountRepository) {
        this.accountRepository = AccountRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Account> loggedAccountOpt = accountRepository.findByUsername(username);

        Account Account = loggedAccountOpt.orElseThrow(() -> new UsernameNotFoundException("Username was not found."));

        List<String> authorities = Account.getAuthoritiesAsStrings();
        Collection<GrantedAuthority> securityAuthorities = AuthorityUtils.createAuthorityList(authorities.toArray(new String[0]));

        return new SecurityAccount(username, Account.getPassword(), securityAuthorities);
    }
}
