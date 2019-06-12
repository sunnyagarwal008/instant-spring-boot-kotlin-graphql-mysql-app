package com.example.taxify.modules.person

import java.io.Serializable
import java.util.UUID
import javax.persistence.*
import javax.persistence.CascadeType.ALL
import javax.persistence.GenerationType.IDENTITY

@Entity
@Table(name = "person", uniqueConstraints = [UniqueConstraint(columnNames = ["email"])])
data class Person(
        @Id
        @GeneratedValue(strategy = IDENTITY)
        var id: Integer? = null,

        val code: String = UUID.randomUUID().toString(),

        val name: String,

        @Column
        val email: String,

        @OneToMany(fetch = FetchType.EAGER, mappedBy = "person", cascade = [ALL], orphanRemoval = true)
        var phoneNumbers: List<PhoneNumber>? = null
)  : Serializable