package com.udemy.hello.controller;

import java.util.Date;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class HelloController {
	
	@Autowired
	private JobLauncher jobLauncher;
	
	@Autowired
	@Qualifier("helloJob")
	private Job job;
	
	@PostMapping("/launch")
	public void launchJob(@RequestBody JobLaunchRequest request) throws Exception {
		JobParametersBuilder jobParametersBuilder = new JobParametersBuilder();
		jobParametersBuilder.addString("param1", request.getParam1());
		jobParametersBuilder.addString("param2", request.getParam2());
		// 複数実行時の対策として入れておく
		jobParametersBuilder.addDate("date", new Date());
		
		JobExecution execution = jobLauncher.run(job, jobParametersBuilder.toJobParameters());
		
		log.info("Exit Status:" + execution.getStatus());
		
	}
	
	//ウェブから見たい場合
    @GetMapping("/launch")
    public String launchJobGet() {
        return "Use POST method to launch the job.";
    }

}
