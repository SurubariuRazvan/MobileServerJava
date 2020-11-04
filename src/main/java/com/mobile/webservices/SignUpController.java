package com.mobile.webservices;

import com.mobile.domain.model.Account;
import com.mobile.domain.model.Authority;
import com.mobile.domain.model.User;
import com.mobile.domain.model.dto.SignUpDTO;
import com.mobile.services.AccountService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class SignUpController {

    private final AccountService  accountService;
    private final PasswordEncoder passwordEncoder;

    public SignUpController(AccountService accountService, PasswordEncoder passwordEncoder) {
        this.accountService = accountService;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/signup")
    public ResponseEntity<String> signUp(@RequestBody SignUpDTO signUpData) {
        User user = new User(0L, signUpData.getName(), null);

        List<String> authorities = signUpData.getAuthorities();
        authorities = authorities == null ? Collections.emptyList() : authorities;

        Account account = new Account(0L, signUpData.getUsername(), passwordEncoder.encode(signUpData.getPassword()), user,
                                      authorities.stream()
                                              .map(authority -> new Authority(0L, authority))
                                              .collect(Collectors.toList()));

        user.setAccount(account);
        accountService.saveAccount(account);
        return ResponseEntity.ok("Account created successfully");
    }
}
