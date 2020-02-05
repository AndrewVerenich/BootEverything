package com.andver.firstApp.controller;

import org.springframework.batch.core.*;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SimpleController {

    private final String SELECT = "SELECT current_count FROM count WHERE id=1";
    private final String UPDATE = "UPDATE count SET current_count = current_count + 1 WHERE id = 1";

    private final JdbcTemplate template;
    private JobLauncher jobLauncher;
    private Job job;

    @Autowired
    public SimpleController(JdbcTemplate template, JobLauncher jobLauncher, Job job) {
        this.template = template;
        this.jobLauncher = jobLauncher;
        this.job = job;
    }

    @GetMapping("/")
    String home() {
        String string = "Hello World!" + template.queryForObject(SELECT, String.class);
        template.update(UPDATE);
        return string;
    }

    @GetMapping("/runJob")
    public String runJob() throws JobParametersInvalidException, JobExecutionAlreadyRunningException,
            JobRestartException, JobInstanceAlreadyCompleteException {
        JobParameters jobParameters =
                new JobParametersBuilder()
                        .addLong("time", System.currentTimeMillis()).toJobParameters();
        JobExecution run = jobLauncher.run(job, jobParameters);
        run.stop();
        return "Job launched";
    }

}
