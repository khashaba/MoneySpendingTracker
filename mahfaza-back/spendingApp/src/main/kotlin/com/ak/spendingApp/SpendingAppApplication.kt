package com.ak.spendingApp

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan

@SpringBootApplication
@ComponentScan(basePackages = ["com.ak.spendingApp"])
class SpendingAppApplication

fun main(args: Array<String>) {
	runApplication<SpendingAppApplication>(*args)
}
