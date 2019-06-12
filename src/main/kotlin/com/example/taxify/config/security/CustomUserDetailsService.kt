package com.example.taxify.config.security

import com.example.taxify.modules.user.UserRepository
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Component

@Component
class CustomUserDetailsService(private val userRepository: UserRepository) : UserDetailsService {

    override fun loadUserByUsername(email: String): UserDetails {
        return userRepository
                .findByEmail(email)
                .orElseThrow { UsernameNotFoundException("Username: $email not found") }
    }
}