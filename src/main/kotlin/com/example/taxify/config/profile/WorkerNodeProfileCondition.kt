package com.example.taxify.config.profile

import org.springframework.core.env.Environment
import java.util.Arrays

class WorkerNodeProfileCondition : ProfileCondition() {

    override fun matchProfiles(environment: Environment): Boolean {
        return Arrays
                .stream(environment.getActiveProfiles())
                .anyMatch { profile -> profile.contains("worker") }
    }
}