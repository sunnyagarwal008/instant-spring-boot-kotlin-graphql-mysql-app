package com.example.taxify.modules.person

data class PersonInput(
        val name: String,
        val email: String,
        val phoneNumbers: List<String>? = null
)