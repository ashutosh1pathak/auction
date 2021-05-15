package com.eauction.www.auction.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;
import java.util.Collection;

@Service
public class RequestContext {


 private Collection<? extends GrantedAuthority> authorities;
 private String username;
 private boolean isAdmin;


    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
