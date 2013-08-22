package com.rabbit.pm25.viewcontroller.dao;

import com.rabbit.pm25.data.domain.Station;
import org.springframework.stereotype.Repository;

/**
 * Created with IntelliJ IDEA.
 * User: Mac
 * Date: 13-8-21
 * Time: 上午9:58
 * To change this template use File | Settings | File Templates.
 */
@Repository("stationDao")
public class StationDao extends GenericDAO<Station> implements IStationDao {

    public StationDao() {
        super(Station.class);
    }
}
