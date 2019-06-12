package com.example.taxify

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class TaxifyApplication

fun main(args: Array<String>) {
	runApplication<TaxifyApplication>(*args)
}
