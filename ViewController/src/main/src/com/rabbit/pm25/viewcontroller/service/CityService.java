package com.rabbit.pm25.viewcontroller.service;

import com.rabbit.pm25.data.domain.City;
import com.rabbit.pm25.viewcontroller.dao.ICityDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Mac
 * Date: 13-8-18
 * Time: 下午11:52
 * To change this template use File | Settings | File Templates.
 */
@Service("cityService")
public class CityService implements ICityService {

    @Autowired
    private ICityDao cityDao;

    public CityService() {

    }

    @Override
    public List<City> listAll() {

        return cityDao.queryAll();

    }

    @Override
    public void batchInsert(List<City> list) {
        cityDao.batchInsert(list);
    }


}
