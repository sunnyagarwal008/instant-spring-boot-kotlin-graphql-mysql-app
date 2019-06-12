package com.example.taxify.modules.user

import java.io.Serializable
import javax.persistence.*
import javax.persistence.GenerationType.IDENTITY

@Entity
@Table(name = "user_role")
data class UserRole(
        @Id
        @GeneratedValue(strategy = IDENTITY)
        var id: Integer? = null,

        @ManyToOne(fetch = FetchType.EAGER)
        @JoinColumn(name = "user_code", nullable = false, referencedColumnName = "code")
        var user: User? = null,

        @Column(nullable = false)
        val role: String
) : Serializable