package com.springboot.mybatisdemo.dao;

import com.springboot.mybatisdemo.domain.City;
import org.apache.ibatis.annotations.Param;

/**
 * 查询城市信息
 *
 * @param cityName 城市名
 */
public interface CityDao {
    City findByName(@Param("cityName") String cityName);
}
