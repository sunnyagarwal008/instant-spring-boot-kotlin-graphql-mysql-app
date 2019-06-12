package com.example.taxify.modules.person

import com.coxautodev.graphql.tools.GraphQLMutationResolver
import com.example.taxify.modules.person.PersonInput
import com.example.taxify.modules.person.PersonService

import org.springframework.stereotype.Component

@Component
class PersonMutation(private val personService: PersonService) : GraphQLMutationResolver {

    fun personCreate(input: PersonInput) =
            personService.createPerson(input.name, input.email, input.phoneNumbers)
}