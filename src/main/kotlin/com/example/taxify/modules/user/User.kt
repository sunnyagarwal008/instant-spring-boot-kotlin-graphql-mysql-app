package com.example.taxify.modules.user

import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import java.util.UUID
import javax.persistence.*
import javax.persistence.CascadeType.ALL
import javax.persistence.GenerationType.IDENTITY

@Entity
@Table(name = "user", uniqueConstraints = [UniqueConstraint(columnNames = ["email"])])
data class User(
        @javax.persistence.Id
        @GeneratedValue(strategy = IDENTITY)
        var id: Integer? = null,
        val code: String = UUID.randomUUID().toString(),
        val email: String,
        val encryptedPassword: String,

        @OneToMany(fetch = FetchType.EAGER, mappedBy = "user", cascade = [ALL], orphanRemoval = true)
        var roles: List<UserRole>
) : UserDetails {
    override fun getAuthorities() = roles.map { role -> SimpleGrantedAuthority(role.role) }

    override fun isEnabled() = true

    override fun getUsername() = email

    override fun isCredentialsNonExpired() = true

    override fun getPassword() = encryptedPassword

    override fun isAccountNonExpired() = true

    override fun isAccountNonLocked() = true
}