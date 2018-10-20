package com.example.demo

import org.camunda.bpm.engine.RuntimeService
import org.camunda.bpm.spring.boot.starter.annotation.EnableProcessApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.scheduling.annotation.EnableScheduling

@SpringBootApplication
@EnableProcessApplication
@EnableScheduling
class DemoApplication(val runtimeService: RuntimeService)

fun main(args: Array<String>) {
    runApplication<DemoApplication>(*args)
}
