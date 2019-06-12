package com.example.taxify.config.flyway

import org.flywaydb.core.Flyway
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class FlywayController(private val flyway: Flyway) {

    private val logger = LoggerFactory.getLogger(FlywayController::class.java)

    @PostMapping("/flyway/migrate")
    fun migrate() {
        logger.info("Running flyway migration")
        flyway.migrate()
        logger.info("Completed flyway migration")
    }
}