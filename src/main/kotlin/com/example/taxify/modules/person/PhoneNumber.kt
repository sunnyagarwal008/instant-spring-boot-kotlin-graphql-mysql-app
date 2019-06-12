package com.example.taxify.modules.person

import java.io.Serializable
import javax.persistence.*
import javax.persistence.GenerationType.IDENTITY

@Entity
@Table(name = "phone_number")
data class PhoneNumber(
        @Id
        @GeneratedValue(strategy = IDENTITY)
        var id: Integer? = null,

        @ManyToOne(fetch = FetchType.EAGER)
        @JoinColumn(name = "person_code", nullable = false, referencedColumnName = "code")
        var person: Person? = null,

        @Column(nullable = false)
        val number: String
) : Serializable