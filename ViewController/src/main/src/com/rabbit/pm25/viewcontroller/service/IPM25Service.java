package com.rabbit.pm25.viewcontroller.service;

import com.rabbit.pm25.data.domain.PM25;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Mac
 * Date: 13-8-20
 * Time: 下午11:54
 * To change this template use File | Settings | File Templates.
 */
public interface IPM25Service {

    void saveCurrentPM25();
    List<PM25> listByCity(String city);

}
