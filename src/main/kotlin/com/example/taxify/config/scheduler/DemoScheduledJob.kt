package com.example.taxify.config.scheduler

import net.javacrumbs.shedlock.core.SchedulerLock
import org.slf4j.LoggerFactory
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component

@Component
class DemoScheduledJob {

    companion object {
        private val logger = LoggerFactory.getLogger(DemoScheduledJob::class.java)
    }

    // Run every 10 seconds
    @Scheduled(cron = "*/10 * * ? * *")
    @SchedulerLock(name = "DemoScheduledJob_scheduledTask")
    fun scheduledTask() {
        logger.info("Running scheduled job")
    }
}