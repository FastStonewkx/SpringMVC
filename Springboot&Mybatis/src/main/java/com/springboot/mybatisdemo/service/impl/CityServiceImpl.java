package com.springboot.mybatisdemo.service.impl;

import com.springboot.mybatisdemo.dao.CityDao;
import com.springboot.mybatisdemo.domain.City;
import com.springboot.mybatisdemo.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CityServiceImpl implements CityService {

    @Autowired
    private CityDao cityDao;


    public City findCityByName(String cityName){
        return cityDao.findByName(cityName);
    }
}
