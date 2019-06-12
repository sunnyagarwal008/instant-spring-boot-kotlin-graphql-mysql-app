package com.example.taxify.dbunit.mysql

import com.example.taxify.MySqlContainerConfiguration
import com.example.taxify.MySqlContainerConfiguration.MySqlTestInitializer
import org.junit.runner.RunWith
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace.NONE
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.context.annotation.Import
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner::class)
@DataJpaTest
@ContextConfiguration(initializers = arrayOf(MySqlTestInitializer::class))
@Import(MySqlContainerConfiguration::class)
@AutoConfigureTestDatabase(replace = NONE)
abstract class AbstractMySqlRepositoryTest