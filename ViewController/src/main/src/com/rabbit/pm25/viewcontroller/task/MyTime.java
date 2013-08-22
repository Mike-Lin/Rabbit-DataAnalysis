package com.rabbit.pm25.viewcontroller.task;

import com.sun.jmx.snmp.Timestamp;

/**
 * Created with IntelliJ IDEA.
 * User: Mac
 * Date: 13-8-21
 * Time: 下午10:56
 * To change this template use File | Settings | File Templates.
 */
public class MyTime {

    public void getTime()
    {
        Timestamp tt = new Timestamp(System.currentTimeMillis());
        System.out.println(tt.toString());
    }
}
