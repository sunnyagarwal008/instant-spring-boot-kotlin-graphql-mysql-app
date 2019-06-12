package com.example.taxify

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.boot.test.util.TestPropertyValues
import org.springframework.context.ApplicationContextInitializer
import org.springframework.context.ConfigurableApplicationContext
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Primary
import org.testcontainers.containers.MySQLContainer
import javax.annotation.PreDestroy

@Configuration
class MySqlContainerConfiguration {

    companion object {
        private val logger: Logger = LoggerFactory.getLogger(MySqlContainerConfiguration::class.java)

        val MYSQL_CONTAINER = object : MySQLContainer<Nothing>() {
            init {
                withDatabaseName("example")
                withConfigurationOverride("mysqlconf")
            }
        }

        init {
            //
            // Can't start mysql container in @PostConstruct and have to do it here because we need to override the
            // mysql datasource and flyway configuration {@link MySqlTestInitializer}. Can be avoided by creating the
            // datasource bean which JPA uses and flyway bean
            //
            logger.info("Starting mysql test container")
            MYSQL_CONTAINER.start()
        }
    }

//    @PostConstruct
//    fun start() {
//        logger.info("Starting mysql test container")
//        MYSQL_CONTAINER.start()
//    }

    @PreDestroy
    fun stop() {
        MYSQL_CONTAINER.stop()
    }

    @Bean
    @Primary
    fun mysqlContainer(): MySQLContainer<Nothing> {
        return MYSQL_CONTAINER
    }

    internal class MySqlTestInitializer : ApplicationContextInitializer<ConfigurableApplicationContext> {
        override fun initialize(configurableApplicationContext: ConfigurableApplicationContext) {
            TestPropertyValues.of(
                    "spring.datasource.url=${MYSQL_CONTAINER.jdbcUrl}",
                    "spring.datasource.username=${MYSQL_CONTAINER.username}",
                    "spring.datasource.password=${MYSQL_CONTAINER.password}",
                    "spring.flyway.url=${MYSQL_CONTAINER.jdbcUrl}",
                    "spring.flyway.user=${MYSQL_CONTAINER.username}",
                    "spring.flyway.password=${MYSQL_CONTAINER.password}",
                    "spring.flyway.schemas=example"
            ).applyTo(configurableApplicationContext.environment)
        }
    }
}