package com.dio.live.swagger;

import java.util.ArrayList;
import java.util.Arrays;
import io.swagger.models.auth.In;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com/dio/live"))
                .paths(PathSelectors.ant("/*"))
                .build().apiInfo(metaInfo())
                .useDefaultResponseMessages(false)
                .securitySchemes(Arrays.asList(new ApiKey("Token Access", HttpHeaders.AUTHORIZATION, In.HEADER.name())));
    }

    private ApiInfo metaInfo() {
        ApiInfo apiInfo = new ApiInfo(
                "API-REST",
                "Api para gerenciamento de ponto de acesso",
                "1.0.0",
                "Terms of Service",
                new Contact("Diogo", "https://github.com/Preventer-Wind", "pradalegion@gmail.com"),
                "Apache License Version 2.0",
                "http://www.apache.org/licenses/LICENSE-2.0", new ArrayList<VendorExtension>()
        );
        return apiInfo;
    }
}