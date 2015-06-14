package com.hotel.gateway;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.mangofactory.swagger.plugin.EnableSwagger;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;

@SpringBootApplication
@EnableEurekaServer
@EnableEurekaClient
@EnableFeignClients
@EnableDiscoveryClient
@RestController
@EnableHystrix
@EnableSwagger
@Api(value = "hotelGateway", description = "HotelGateway API")
public class HotelGatewayApplication {
    @Autowired
    private HotelGatewayService gatewayService;

    public static void main(String[] args) {
        SpringApplication.run(HotelGatewayApplication.class, args);
    }
    
    @RequestMapping(value="/summary/{hotelId}", method = RequestMethod.GET)
    @ApiOperation(value = "getHotelSummary", notes = "Returns Hotel Name & Price")
    public String getHotelSummary(@PathVariable String hotelId) throws Exception {
        Gson gson = new Gson(); 
        String json = gson.toJson(gatewayService.getHotelSummary(hotelId)); 
        return json;
    }

    @RequestMapping(value="/info/{hotelId}", method = RequestMethod.GET)
    @ApiOperation(value = "getHotelDetails", notes = "Returns Hote Name, Price, Reviews & Rating")
    public String getHotelInfo(@PathVariable String hotelId) throws Exception {
        Gson gson = new Gson();
        String json = gson.toJson(gatewayService.getHotel(hotelId));
        return json;
    }
}
