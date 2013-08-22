package com.rabbit.pm25.viewcontroller.dao;

import com.rabbit.pm25.data.domain.City;
import org.springframework.stereotype.Repository;

/**
 * Created with IntelliJ IDEA.
 * User: Mac
 * Date: 13-8-15
 * Time: 下午5:58
 * To change this template use File | Settings | File Templates.
 */

@Repository("cityDao")
public class CityDao extends GenericDAO<City> implements ICityDao {


    public CityDao() {
        super(City.class);
    }

}
