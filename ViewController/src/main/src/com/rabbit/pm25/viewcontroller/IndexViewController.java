package com.rabbit.pm25.viewcontroller;

import com.rabbit.pm25.data.AnalyzeData;
import com.rabbit.pm25.data.domain.City;
import com.rabbit.pm25.viewcontroller.service.ICityService;
import com.rabbit.pm25.viewcontroller.service.IDataService;
import com.rabbit.pm25.viewcontroller.service.IPM25Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Mac
 * Date: 13-8-18
 * Time: 上午2:21
 * To change this template use File | Settings | File Templates.
 */
@Controller
public class IndexViewController {


    @Autowired
    private ICityService cityService;
    @Autowired
    private IDataService dataService;
    @Autowired
    private IPM25Service pm25Service;


    @RequestMapping("/")
    public ModelAndView home(HttpServletRequest request) {

        List<City> list = cityService.listAll();

        System.out.println("list.size() \t" + list.size());
//
//
//        CityDao cityDao = new CityDao();
//        City city = cityDao.queryByName("天津");
//
//        PM25Dao pm25Dao = new PM25Dao();
//        List<PM25> list = pm25Dao.queryByCity(city);
//
//        request.setAttribute("list", list);

        ModelAndView mav = new ModelAndView("WEB-INF/views/index.jsp");

        return mav;
    }


    @RequestMapping("/cityList")
    public ModelAndView cityList(HttpServletRequest request) {

        List<City> list = cityService.listAll();

        request.setAttribute("list", list);

        return new ModelAndView("WEB-INF/views/cityList.jsp");
    }

    @RequestMapping("/saveCities")
    public ModelAndView saveCities(HttpServletRequest request) {

        cityService.batchInsert(AnalyzeData.citys());

        request.setAttribute("list", AnalyzeData.citys());

        return new ModelAndView("WEB-INF/views/cityList.jsp");
    }

    @RequestMapping("/savePM25")
    public ModelAndView savePM25(HttpServletRequest request) {

        pm25Service.saveCurrentPM25();

        request.setAttribute("list", AnalyzeData.citys());

        return new ModelAndView("WEB-INF/views/cityList.jsp");
    }

}
