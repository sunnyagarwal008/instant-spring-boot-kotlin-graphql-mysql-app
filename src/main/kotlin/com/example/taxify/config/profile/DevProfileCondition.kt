package com.example.taxify.config.profile

import org.springframework.core.env.Environment
import java.util.Arrays

class DevProfileCondition : ProfileCondition() {

    override fun matchProfiles(environment: Environment): Boolean {
        return Arrays
                .stream(environment.getActiveProfiles())
                .anyMatch { prof ->
                    (prof.equals("local") || prof.equals("integration-test"));
                }
    }
}