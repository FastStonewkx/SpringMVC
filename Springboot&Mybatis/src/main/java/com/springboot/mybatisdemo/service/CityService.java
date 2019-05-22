package com.springboot.mybatisdemo.service;

import com.springboot.mybatisdemo.domain.City;

public interface CityService {
    City findCityByName(String cityName);
}
