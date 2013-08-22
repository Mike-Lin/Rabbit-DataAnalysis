package com.rabbit.pm25.viewcontroller.service;

import com.rabbit.pm25.data.domain.City;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Mac
 * Date: 13-8-18
 * Time: 下午11:50
 * To change this template use File | Settings | File Templates.
 */

// 只要在接口上用@Transactional注解，此接口内的所有方法就自动声明为事务了，方法即是事务的边界。
// 后面的propagation参数，至少要到REQUIRED，否则No Session found for current thread，我也不知道这算不算一个BUG，还是spring认为是一个强制要求
@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
public interface ICityService {
    List<City> listAll();
    void batchInsert(List<City> list);
}
