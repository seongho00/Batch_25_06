package com.koreait.exam.batch_25_06.job.helloWorld;


import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.JobScope;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class HelloWorldJobConfig {
    private final JobBuilderFactory jobBuilderFactory;
    private final StepBuilderFactory stepBuilderFactory;

    // job : 여러 개의 step 들로 구성됨

    // job -> step -> task 순서로 진행


    @Bean
    public Job helloWordJob() {
        return jobBuilderFactory
                .get("helloWorldJob")
//                .incrementer(new RunIdIncrementer()) // 매번 새로운 아이디 부여 -> 모든 시도가 다 다르게 들어감
                .start(helloWorldStep1()) 
                .next(helloWorldStep2())
                .build();
    }

    @Bean
    @JobScope
    public Step helloWorldStep1() {
        return stepBuilderFactory
                .get("helloWorldStep1")
                .tasklet(helloWordTasklet1())
                .build();
    }

    @Bean
    @StepScope
    public Tasklet helloWordTasklet1() {
        return (contribution, chunkContext) -> {
            System.out.println("헬로월드!1111");
            return RepeatStatus.FINISHED;
        };
    }

    @Bean
    @JobScope
    public Step helloWorldStep2() {
        return stepBuilderFactory
                .get("helloWorldStep1")
                .tasklet(helloWordTasklet2())
                .build();
    }

    @Bean
    @StepScope
    public Tasklet helloWordTasklet2() {
        return (contribution, chunkContext) -> {
            System.out.println("헬로월드!22222");

//            throw new Exception(); return 값이 실행될리가 없어 오류 발생

            if (true) {
                throw new Exception("실패 : 의도적인 실패");
            }

            return RepeatStatus.FINISHED;
        };
    }

}
