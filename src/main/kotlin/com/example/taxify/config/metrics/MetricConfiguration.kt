package com.example.taxify.config.metrics

import com.example.taxify.config.profile.DevProfileCondition
import com.example.taxify.config.profile.ProdProfileCondition
import io.micrometer.core.instrument.Clock
import io.micrometer.core.instrument.MeterRegistry
import io.micrometer.core.instrument.logging.LoggingMeterRegistry
import io.micrometer.core.instrument.logging.LoggingRegistryConfig
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Conditional
import org.springframework.context.annotation.Configuration
import java.time.Duration

@Configuration
@Conditional(ProdProfileCondition::class)
class MetricConfiguration {

    @Bean
    fun loggingRegistryConfig(): LoggingRegistryConfig {
        return object : LoggingRegistryConfig {
            override fun get(key: String) = null
            override fun step() = Duration.ofSeconds(10)
        }
    }

    @Bean
    fun meterRegistry(config: LoggingRegistryConfig): MeterRegistry {
        return LoggingMeterRegistry(config, Clock.SYSTEM);
    }
}
