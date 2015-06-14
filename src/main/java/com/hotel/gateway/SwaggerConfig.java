package com.hotel.gateway;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.mangofactory.swagger.configuration.SpringSwaggerConfig;
import com.mangofactory.swagger.models.dto.ApiInfo;
import com.mangofactory.swagger.plugin.SwaggerSpringMvcPlugin;

@Configuration
public class SwaggerConfig {
    private SpringSwaggerConfig springSwaggerConfig;
 
    @Autowired
    public void setSpringSwaggerConfig(SpringSwaggerConfig springSwaggerConfig) {
        this.springSwaggerConfig = springSwaggerConfig;
    }
 
    @Bean
    public SwaggerSpringMvcPlugin hotelGatewayAPI() {
        return new SwaggerSpringMvcPlugin(this.springSwaggerConfig).swaggerGroup("hotelGateway").apiInfo(
                apiInfo()).includePatterns("/summary/.*", "/info/.*");
    }
    
    private ApiInfo apiInfo() {
        ApiInfo apiInfo = new ApiInfo("HotelGateway API", "API for HotelGateway","", "","", "");
        return apiInfo;
    }
}
