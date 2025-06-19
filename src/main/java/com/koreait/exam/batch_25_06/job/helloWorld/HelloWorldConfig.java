package com.koreait.exam.batch_25_06.job.helloWorld;


import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@RequiredArgsConstructor
public class HelloWorldConfig {
    private final JobRepository jobRepository;
    private final PlatformTransactionManager transactionManager;

    // job : 여러 개의 step 들로 구성됨

    // job -> step -> task 순서로 진행


    @Bean
    public Job helloWordJob() {
        return new JobBuilder("helloWorldJob", jobRepository)
                .start(helloWorldStep1())
                .build();
    }

    @Bean
    public Step helloWorldStep1() {
        return new StepBuilder("helloWorldStep1", jobRepository)
                .tasklet(helloWordTasklet(), transactionManager)
                .build();
    }

    @Bean
    public Tasklet helloWordTasklet() {
        return (StepContribution contribution, ChunkContext chunkContext) -> {
            System.out.println("helloWorld!");
            return RepeatStatus.FINISHED;
        };
    }

}
