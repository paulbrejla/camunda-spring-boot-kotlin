package com.example.demo

import org.camunda.bpm.engine.RepositoryService
import org.camunda.bpm.engine.RuntimeService
import org.camunda.bpm.engine.TaskService
import org.springframework.stereotype.Component
import org.slf4j.LoggerFactory.getLogger
import org.springframework.scheduling.annotation.Scheduled

@Component
class Showcase(val runtimeService: RuntimeService, val taskService: TaskService, val repositoryService: RepositoryService) {

    private val logger = getLogger(this.javaClass)

    @Scheduled(fixedDelay = 10000L)
    fun startProcess() {
        val processInstanceId = runtimeService
                .startProcessInstanceByKey("Sample", mapOf("productId" to "camera-produsct"))
                .processInstanceId

        logger.info("started instance: {}", processInstanceId)

        val task = taskService.createTaskQuery().processInstanceId(processInstanceId).singleResult()
        taskService.complete(task.getId())
        logger.info("completed task: {}", task)
    }
}