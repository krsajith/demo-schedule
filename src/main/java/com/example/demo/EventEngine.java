package com.example.demo;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;

@Service
public class EventEngine  implements InitializingBean {
    private final ThreadPoolTaskScheduler taskScheduler;
    private final TemporalUnit temporalUnit = ChronoUnit.MILLIS;
    public EventEngine(ThreadPoolTaskScheduler taskScheduler) {
        this.taskScheduler = taskScheduler;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        taskScheduler.scheduleWithFixedDelay(
                () -> System.out.println("Send event"), Duration.of(1000, temporalUnit));
    }
}
