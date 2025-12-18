package com.example.perpusonline.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    // Bean ini HARUS ada untuk mengenkripsi password
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // 💡 PENAMBAHAN: Bean UserDetailsService untuk mendefinisikan user admin
    @Bean
    public UserDetailsService userDetailsService(PasswordEncoder passwordEncoder) {
        // Mendefinisikan user 'admin' dengan password 'admin123'
        UserDetails admin = User.builder()
                .username("admin")
                // Password di-encode menggunakan BCryptPasswordEncoder
                .password(passwordEncoder.encode("admin123")) 
                .roles("ADMIN")
                .build();

        return new InMemoryUserDetailsManager(admin);
    }


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable()) // Nonaktifkan CSRF untuk API
            .authorizeHttpRequests(authorize -> authorize
                // Izinkan akses PUBLIK ke halaman user dan API Katalog/Peminjaman
                .requestMatchers(
                    "/login", 
                    "/", 
                    "/user/**", 
                    "/api/katalog/**", 
                    "/api/peminjaman/save" 
                ).permitAll()
                // Akses ADMIN memerlukan role ADMIN
                .requestMatchers("/admin/**", "/api/admin/**").hasRole("ADMIN")
                // Semua request lainnya HARUS diautentikasi
                .anyRequest().authenticated()
            )
            .formLogin(form -> form
                .loginPage("/login")
                .defaultSuccessUrl("/admin/buku", true) 
                .permitAll()
            )
            .logout(logout -> logout
                .logoutUrl("/logout")
                .logoutSuccessUrl("/login?logout")
                .permitAll()
            );
        return http.build();
    }
}