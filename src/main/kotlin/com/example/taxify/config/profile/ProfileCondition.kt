package com.example.taxify.config.profile

import org.springframework.boot.autoconfigure.condition.ConditionOutcome
import org.springframework.boot.autoconfigure.condition.SpringBootCondition
import org.springframework.context.annotation.ConditionContext
import org.springframework.core.env.Environment
import org.springframework.core.type.AnnotatedTypeMetadata

abstract class ProfileCondition: SpringBootCondition() {

    override fun getMatchOutcome(context: ConditionContext?, metadata: AnnotatedTypeMetadata?): ConditionOutcome {
        if (matchProfiles(context?.getEnvironment()!!)) {
            return ConditionOutcome.match("profile match found");
        }
        return ConditionOutcome.noMatch("profile match not found");
    }

    internal abstract fun matchProfiles(environment: Environment): Boolean
}
