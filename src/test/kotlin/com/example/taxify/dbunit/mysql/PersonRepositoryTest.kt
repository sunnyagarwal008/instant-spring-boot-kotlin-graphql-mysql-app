package com.example.taxify.dbunit.mysql

import com.example.taxify.modules.person.Person
import com.example.taxify.modules.person.PersonRepository
import org.hamcrest.Matchers.equalTo
import org.junit.Assert.assertThat
import org.junit.Test
import org.springframework.beans.factory.annotation.Autowired

class PersonRepositoryTest : AbstractMySqlRepositoryTest() {

    @Autowired
    lateinit var personRepository: PersonRepository

    @Test
    fun `findByNameIgnoreCaseContaining matches partial names`() {
        val person = Person(name = "test", email = "test@test.com")
        personRepository.save(person)

        val actual = personRepository.findByNameIgnoreCaseContaining("tes")

        assertThat(actual.size, equalTo(1));
        assertThat(actual.get(0).email, equalTo("test@test.com"));
        assertThat(actual.get(0).name, equalTo("test"));
    }


    @Test
    fun `data is cleaned up after tests`() {

        val actual = personRepository.findByNameIgnoreCaseContaining("tes")

        assertThat(actual.size, equalTo(0));
    }
}