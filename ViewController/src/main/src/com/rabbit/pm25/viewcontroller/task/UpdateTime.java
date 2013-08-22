package com.rabbit.pm25.viewcontroller.task;

/**
 * Created with IntelliJ IDEA.
 * User: Mac
 * Date: 13-8-21
 * Time: 下午10:57
 * To change this template use File | Settings | File Templates.
 */

import com.rabbit.pm25.viewcontroller.service.IDataService;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.stereotype.Component;

/**
 * spring 定时任务
 * @author spring sky
 * Email:vipa1888@163.com
 * QQ:840950105
 * #####spring 定时任务需要继承QuartzJobBean 这种方式是最常用的！
 * #####同时就实现了抽象方法executeInternal
 *
 */
@Component
public class UpdateTime extends QuartzJobBean {

    @Autowired
    private IDataService dataService;

    private MyTime myTime;
    /**
     * 依赖注入myTime
     * @param myTime
     */
    public void setMyTime(MyTime myTime) {
        this.myTime = myTime;
    }

    /**
     * 我在这个定时任务里面只做了一个很简单的事情，就是打印出当前的时间！
     */
    @Override
    protected void executeInternal(JobExecutionContext context)
            throws JobExecutionException {

        dataService.saveOrUpdatePM25();

    }

}