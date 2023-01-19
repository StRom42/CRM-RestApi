package com.crm.web.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.BasicAuth;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;
import java.util.List;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

    private final String BASE_AUTH = "basic_auth";
    @Bean
    public Docket api(){
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.crm.web.Controllers"))
                .paths(PathSelectors.any())
                .build()
                .pathMapping("/")
                .securitySchemes(Collections.singletonList(new BasicAuth(BASE_AUTH)))
                .securityContexts(Collections.singletonList(securityContext()));
    }

    private SecurityContext securityContext(){
        return SecurityContext.builder()
                .securityReferences(basicAuthReference())
                .forPaths(PathSelectors.any())
                .build();
    }

    List<SecurityReference> basicAuthReference() {
        return Collections.singletonList(
                new SecurityReference(BASE_AUTH, new AuthorizationScope[0]));
    }
}
