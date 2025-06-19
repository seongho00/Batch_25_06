package com.koreait.exam.batch_25_06.job.helloWorld;


import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class HelloWorldConfig {
    private final JobBuilderFactory jobBuilderFactory;
    private final StepBuilderFactory stepBuilderFactory;

    // job : 여러 개의 step 들로 구성됨

    // job -> step -> task 순서로 진행


    @Bean
    public Job helloWordJob() {
        return jobBuilderFactory.get("helloWorldJob")
                .incrementer(new RunIdIncrementer())
                .start(helloWorldStep1())
                .build();
    }

    @Bean
    public Step helloWorldStep1() {
        return stepBuilderFactory.get("helloWorldStep1")
                .tasklet(helloWordTasklet())
                .build();
    }

    @Bean
    public Tasklet helloWordTasklet() {
        return (contribution, chunkContext) -> {
            System.out.println("헬로월드!");
            return RepeatStatus.FINISHED;
        };
    }

}
