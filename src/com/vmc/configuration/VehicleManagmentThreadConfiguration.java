package com.vmc.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@Configuration
@EnableAsync

public class VehicleManagmentThreadConfiguration {
	 @Bean
	    public TaskExecutor threadPoolTaskExecutor() {
	        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
	        executor.setCorePoolSize(4);
	        executor.setMaxPoolSize(4);
	        executor.setThreadNamePrefix("EE_Thread-");
	        executor.initialize();
	        return executor;
	    }

}
