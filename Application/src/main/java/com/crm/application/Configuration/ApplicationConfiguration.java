package com.crm.application.Configuration;

import com.crm.data.Configuration.DataAccessConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan("com.crm.application.*")
@Import(DataAccessConfiguration.class)
public class ApplicationConfiguration {
}
