package com.hotel.gateway;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("hotelavailability")
public interface HotelAvailabilityClient {

    @RequestMapping(value="/hotel/avail/{hotelId}", method=RequestMethod.GET)
    public String getHotelAvailability(@PathVariable("hotelId") String hotelId);
}
