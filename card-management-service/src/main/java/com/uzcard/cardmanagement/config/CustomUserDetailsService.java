package com.uzcard.cardmanagement.config;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if ("user".equals(username)) { // Misol uchun
            return User.builder()
                    .username("user")
                    .password(new BCryptPasswordEncoder().encode("password")) // Parol shifrlangan bo'lishi kerak
                    .roles("USER") // Rolini o'rnatish
                    .build();
        } else if ("admin".equals(username)) {
            return User.builder()
                    .username("admin")
                    .password(new BCryptPasswordEncoder().encode("admin123"))
                    .roles("ADMIN")
                    .build();
        }
        throw new UsernameNotFoundException("Foydalanuvchi topilmadi: " + username);
    }
}
