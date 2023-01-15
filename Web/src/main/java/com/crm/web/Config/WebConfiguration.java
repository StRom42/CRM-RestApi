package com.crm.web.Config;

import com.crm.application.Configuration.ApplicationConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(ApplicationConfiguration.class)
@ComponentScan("com.crm.web")
public class WebConfiguration {
}
