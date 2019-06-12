package com.example.taxify.graphql

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Profile
import org.springframework.stereotype.Component
import javax.annotation.PostConstruct
import javax.persistence.EntityManager
import javax.persistence.Table
import javax.persistence.metamodel.Metamodel
import javax.transaction.Transactional
import kotlin.reflect.full.findAnnotation

@Component
@Profile("integration-test")
class MySqlCleanupHelper(@Autowired private val entityManager: EntityManager) {

    private lateinit var tableNames: List<String>

    /**
     * Uses the JPA metamodel to find all managed types then try to get the [Table] annotation's from each
     * (if present) to discover the table name.
     * If the [Table] annotation is not defined then we skip that entity (oops :p)
     */
    @PostConstruct
    fun afterPropertiesSet() {
        val metaModel: Metamodel = entityManager.metamodel
        tableNames = metaModel.managedTypes
                .filter {
                    it.javaType.kotlin.findAnnotation<Table>() != null
                }
                .map {
                    val tableAnnotation: Table? = it.javaType.kotlin.findAnnotation()
                    tableAnnotation?.name ?: throw IllegalStateException("should never get here")
                }
    }

    /**
     * Utility method that truncates all identified tables
     */
    @Transactional
    fun truncate() {
        entityManager.flush()
        entityManager.createNativeQuery("SET @@foreign_key_checks = 0").executeUpdate()
        tableNames.forEach { tableName ->
            entityManager.createNativeQuery("TRUNCATE TABLE " + tableName).executeUpdate()
        }
        entityManager.createNativeQuery("SET @@foreign_key_checks = 1").executeUpdate()
    }
}