package com.example.taxify.modules.person

import com.coxautodev.graphql.tools.GraphQLQueryResolver
import com.example.taxify.modules.person.PersonService
import org.springframework.stereotype.Component

@Component
class PersonQueryResolver(private val personService: PersonService) : GraphQLQueryResolver {

    fun persons() = personService.getAll()

    fun person(id: Integer) =
            personService.getPersonById(id)

    fun personsByName(name: String) =
            personService.getPersonsByName(name)
}