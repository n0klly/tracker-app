package com.example.trackerapp.security;

import com.example.trackerapp.entity.User;
import com.example.trackerapp.entity.UserRole;
import org.jspecify.annotations.Nullable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

public class UserDetailsImpl implements UserDetails {

    private Long id;
    private String login;
    private String password;
    private UserRole role;

    public UserDetailsImpl(Long id, String login, String password, UserRole role) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.role = role;
    }

    public static UserDetailsImpl build(User user){
        return new UserDetailsImpl(
                user.getId(),
                user.getLogin(),
                user.getPassword(),
                user.getRole()
        );
    }

    public Long getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public UserRole getRole() {
        return role;
    }


    @Override
    public boolean isAccountNonExpired() {
        return UserDetails.super.isAccountNonExpired();
    }

    @Override
    public boolean isAccountNonLocked() {
        return UserDetails.super.isAccountNonLocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return UserDetails.super.isCredentialsNonExpired();
    }

    @Override
    public boolean isEnabled() {
        return UserDetails.super.isEnabled();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_" + role.name()));
    }

    @Override
    public @Nullable String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.login;
    }
}
