package com.example.taxify.graphql

import com.example.taxify.MySqlContainerConfiguration.MySqlTestInitializer
import com.example.taxify.config.security.SecurityConstants
import com.graphql.spring.boot.test.GraphQLTestTemplate
import org.junit.After
import org.junit.Before
import org.junit.runner.RunWith
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.context.annotation.Import
import org.springframework.http.HttpEntity
import org.springframework.http.HttpHeaders
import org.springframework.http.MediaType.APPLICATION_FORM_URLENCODED
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.util.LinkedMultiValueMap
import org.springframework.util.MultiValueMap

@RunWith(SpringRunner::class)
@SpringBootTest(webEnvironment = RANDOM_PORT)
@ContextConfiguration(initializers = [MySqlTestInitializer::class])
@Import(value = [MySqlTestInitializer::class])
@ActiveProfiles("integration-test")
abstract class AbstractGraphQLIntegrationTest {

    private val logger: Logger = LoggerFactory.getLogger(AbstractGraphQLIntegrationTest::class.java)

    @Autowired
    lateinit var graphQLTestTemplate: GraphQLTestTemplate

    @Autowired
    lateinit var testRestTemplate: TestRestTemplate

    @Autowired
    lateinit var mySqlCleanupHelper: MySqlCleanupHelper

    @Before
    fun addAuthToken() {
        val headers = HttpHeaders()
        headers.contentType = APPLICATION_FORM_URLENCODED
        val map = LinkedMultiValueMap<String, String>()
        map.add("username", "user")
        map.add("password", "password")
        val request = HttpEntity<MultiValueMap<String, String>>(map, headers)
        val response = testRestTemplate.postForEntity("/authenticate", request, String::class.java)
        graphQLTestTemplate.addHeader("Authorization", response.headers.get(SecurityConstants.TOKEN_HEADER)?.getOrNull(0))
    }

    @After
    fun cleanupAfterEach() {
        logger.info("Cleaning up database")
        mySqlCleanupHelper.truncate()
    }
}