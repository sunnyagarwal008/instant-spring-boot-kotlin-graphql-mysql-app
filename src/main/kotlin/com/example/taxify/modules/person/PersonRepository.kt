package com.example.taxify.modules.person

import com.example.taxify.modules.person.Person
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PersonRepository : JpaRepository<Person, Integer> {

    fun findByNameIgnoreCaseContaining(name: String): List<Person>
}