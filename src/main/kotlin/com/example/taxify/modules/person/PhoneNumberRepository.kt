package com.example.taxify.modules.person

import com.example.taxify.modules.person.PhoneNumber
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PhoneNumberRepository : JpaRepository<PhoneNumber, Integer> {

}