package com.example.taxify.modules.person


import org.springframework.stereotype.Component

@Component
class PersonService(private val personRepository: PersonRepository) {

    fun getAll() =
            personRepository.findAll()

    fun getPersonById(id: Integer) =
            personRepository.findById(id)

    fun getPersonsByName(name: String) =
            personRepository.findByNameIgnoreCaseContaining(name)

    fun createPerson(name: String, email: String, numbers: List<String>?): Person {
        val person = Person(name = name, email = email)
        val phoneNumbers = numbers?.map { number -> PhoneNumber(number = number, person = person) }
        person.phoneNumbers = phoneNumbers
        return personRepository.save(person)
    }
}