package com.example.taxify.config.flyway

import com.example.taxify.config.profile.ProdProfileCondition
import org.flywaydb.core.Flyway
import org.slf4j.LoggerFactory
import org.springframework.boot.autoconfigure.flyway.FlywayMigrationStrategy
import org.springframework.context.annotation.Conditional
import org.springframework.stereotype.Component

@Component
@Conditional(ProdProfileCondition::class)
class NoOpFlywayMigrationStrategy : FlywayMigrationStrategy {

    companion object {
        private val logger = LoggerFactory.getLogger(NoOpFlywayMigrationStrategy::class.java)
    }

    override fun migrate(flyway: Flyway?) {
        logger.info("Doing nothing, migration will happen via rest endpoint")
    }
}