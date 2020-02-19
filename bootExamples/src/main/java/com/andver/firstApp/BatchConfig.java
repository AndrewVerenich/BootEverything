package com.andver.firstApp;

import com.andver.firstApp.tasks.MyTaskOne;
import com.andver.firstApp.tasks.MyTaskTwo;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration
@EnableScheduling
@EnableBatchProcessing
public class BatchConfig {

    @Bean
    public Step stepOne(StepBuilderFactory steps) {
        return steps.get("stepOne")
                .tasklet(new MyTaskOne())
                .allowStartIfComplete(true)
                .build();
    }

    @Bean
    public Step stepTwo(StepBuilderFactory steps) {
        return steps.get("stepTwo")
                .tasklet(new MyTaskTwo())
                .allowStartIfComplete(true)
                .build();
    }

    @Bean
    public Job demoJob(JobBuilderFactory jobs, @Qualifier("stepOne") Step stepOne,
                       @Qualifier("stepTwo") Step stepTwo, JobExecutionListener jobExecutionListener) {
        return jobs.get("demoJob")
                .listener(jobExecutionListener)
                .start(stepOne)
                .next(stepTwo)
                .build();
    }
}