package com.andver.firstApp.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.stereotype.Component;

@Component
public class SimpleJobListener implements JobExecutionListener {

    private Logger logger = LoggerFactory.getLogger(SimpleJobListener.class);

    @Override
    public void beforeJob(JobExecution jobExecution) {
        logger.info("--------Job Listener: beforeJob() ------------");
    }

    @Override
    public void afterJob(JobExecution jobExecution) {
        if (jobExecution.getStatus() == BatchStatus.COMPLETED) {
            logger.info("--------Job Listener: afterJob() - COMPLETED status------------");
            return;
        }
        logger.info("--------Job Listener: afterJob() - NOT COMPLETED status------------");
    }
}
