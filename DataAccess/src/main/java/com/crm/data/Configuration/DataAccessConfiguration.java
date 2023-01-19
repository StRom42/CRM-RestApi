package com.crm.data.Configuration;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories("com.crm.data.Repositories")
@ComponentScan("com.crm.data.*")
@EntityScan("com.crm.data.Models.*")
public class DataAccessConfiguration {
}
