package com.example.taxify.graphql

import org.hamcrest.Matchers.equalTo
import org.junit.Assert.*
import org.junit.Test

class PersonServiceTest : AbstractGraphQLIntegrationTest() {

    @Test
    fun `Create Person Without PhoneNumbers`() {
        var response = graphQLTestTemplate.postForResource("graphql/create-person.graphql")
        assertTrue(response.isOk)
        assertNotNull(response.get("\$.data.personCreate.code"))
        assertThat(response.get("\$.data.personCreate.name"), equalTo("Sunny"))
        assertThat(response.get("\$.data.personCreate.email"), equalTo("Sunny@test.com"))
    }

    @Test
    fun `Create Person Without PhoneNumbers duplicate to ensure data is cleaned up after tests`() {
        var response = graphQLTestTemplate.postForResource("graphql/create-person.graphql")
        assertTrue(response.isOk)
        assertNotNull(response.get("\$.data.personCreate.code"))
        assertThat(response.get("\$.data.personCreate.name"), equalTo("Sunny"))
        assertThat(response.get("\$.data.personCreate.email"), equalTo("Sunny@test.com"))
    }

    @Test
    fun `Create Person With PhoneNumbers`() {
        var response = graphQLTestTemplate.postForResource("graphql/create-person-phone.graphql")
        assertTrue(response.isOk)
        assertNotNull(response.get("\$.data.personCreate.code"))
        assertThat(response.get("\$.data.personCreate.name"), equalTo("Sunny"))
        assertThat(response.get("\$.data.personCreate.email"), equalTo("Sunny@testwithphone.com"))
        assertThat(response.get("\$.data.personCreate.phoneNumbers[0].number"), equalTo("123456789"))
    }
}