package com.rabbit.pm25.viewcontroller.service;

import com.rabbit.pm25.data.domain.City;
import com.rabbit.pm25.data.domain.PM25;
import com.rabbit.pm25.viewcontroller.dao.ICityDao;
import com.rabbit.pm25.viewcontroller.dao.IPM25Dao;
import com.rabbit.pm25.viewcontroller.dao.IStationDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Mac
 * Date: 13-8-21
 * Time: 上午11:03
 * To change this template use File | Settings | File Templates.
 */
@Service("dataService")
public class DataService implements IDataService {

    @Autowired
    private ICityDao cityDao;
    @Autowired
    private IStationDao stationDao;
    @Autowired
    private IPM25Dao pm25Dao;

    @Autowired
    private IStationService stationService;
    @Autowired
    private ICityService cityService;
    @Autowired
    private IPM25Service pm25Service;


    @Override
    public void saveCities(List<City> list) {
        cityService.batchInsert(list);
    }


    @Override
    public void savePM25(List<PM25> list) {

        pm25Dao.batchInsert(list);

    }

    @Override
    public void saveOrUpdatePM25(List<PM25> list) {

        pm25Dao.saveOrUpdate(list);

    }

    @Override
    public void saveOrUpdatePM25() {

        List<City> cityList = cityDao.queryAll();

        for (City city : cityList) {

            List<PM25> list = pm25Service.listByCity(city.getName());

            for (PM25 pm25 : list) {

                String hql = "FROM " + PM25.class.getSimpleName() + " pm25 WHERE pm25.timePoint = ?  AND pm25.positionName LIKE ? ";
                System.out.println("hql: \t" + hql);

                List<PM25> pm25InDB = pm25Dao.queryWithHQL(hql, new String[]{pm25.getTimePoint(), pm25.getPositionName(),});
                System.out.println("pm25InDB: \t" + pm25InDB);


                if (pm25InDB != null && pm25InDB.size() < 1) {

                    pm25Dao.insert(pm25);

                }

            }


        }

    }



}
