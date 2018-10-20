package com.example.demo.application

import org.camunda.bpm.engine.delegate.JavaDelegate
import org.springframework.stereotype.Component
import org.camunda.bpm.engine.delegate.DelegateExecution
import org.slf4j.LoggerFactory

@Component
class SayHelloDelegate: JavaDelegate {

    private val logger = LoggerFactory.getLogger(this.javaClass)

    @Throws(Exception::class)
    override fun execute(execution: DelegateExecution) {
        logger.info("executed sayHelloDelegate: {}", execution)
    }
}