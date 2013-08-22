package com.rabbit.pm25.viewcontroller.dao;

import com.rabbit.pm25.data.domain.PM25;
import org.springframework.stereotype.Repository;

/**
 * Created with IntelliJ IDEA.
 * User: Mac
 * Date: 13-8-21
 * Time: 上午11:25
 * To change this template use File | Settings | File Templates.
 */
@Repository("pm25Dao")
public class PM25Dao extends GenericDAO<PM25> implements IPM25Dao {

    public PM25Dao() {

        super(PM25.class);
    }
}
