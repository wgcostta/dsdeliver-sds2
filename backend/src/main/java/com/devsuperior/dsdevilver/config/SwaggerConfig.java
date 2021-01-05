package com.devsuperior.dsdevilver.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    //http://localhost:8080/swagger-ui.html
    private static final String BASE_PACKAGE = "com.devsuperior.dsdevilver";
    private static final String API_TITLE = "API DevSuperior";
    private static final String API_DESCRIPTION = "REST API for Product stock management";
    private static final String CONTACT_NAME = "Wagner Costa";
    private static final String CONTACT_GITHUB = "https://gtihub.com/wgcostta";
    private static final String CONTACT_EMAIL = "wg.o.costa@gmail.com";

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage(BASE_PACKAGE))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title(API_TITLE)
                .description(API_DESCRIPTION)
                .version("1.0.0")
                .contact(new Contact(CONTACT_NAME, BASE_PACKAGE, CONTACT_EMAIL))
                .build();
    }


}
