package com.example.taxify.modules.user

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.Optional

@Repository
interface UserRepository : JpaRepository<User, Integer> {

    fun findByEmail(email: String): Optional<User>
}