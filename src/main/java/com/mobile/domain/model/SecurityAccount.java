package com.mobile.domain.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class SecurityAccount extends User {
    public SecurityAccount(String username, String password, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
    }

    public Account toAppAccount() {
        List<Authority> authorities = new ArrayList<>();
        this.getAuthorities().forEach(grantedAuthority -> authorities.add(new Authority(0L, grantedAuthority.getAuthority())));

        return new Account(0, getUsername(), getPassword(), null, authorities);
    }
}
