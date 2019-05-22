package com.springboot.mybatisdemo.controller;

import com.springboot.mybatisdemo.domain.City;
import com.springboot.mybatisdemo.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CityRestController {

    @Autowired
    private CityService cityService;

    @RequestMapping(value="/api/city", method = RequestMethod.GET)
    public City findOneCity(@RequestParam(value ="cityName", required = true)String cityName){
        return cityService.findCityByName(cityName);
    }
}
