package com.rabbit.pm25.viewcontroller.service;

import com.rabbit.pm25.data.domain.City;
import com.rabbit.pm25.data.domain.PM25;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Mac
 * Date: 13-8-21
 * Time: 上午11:03
 * To change this template use File | Settings | File Templates.
 */
public interface IDataService {

    public void saveCities(List<City> list);
    public void savePM25(List<PM25> list);
    public void saveOrUpdatePM25(List<PM25> list);
    public void saveOrUpdatePM25();

}
