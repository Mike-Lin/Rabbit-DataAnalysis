import com.rabbit.pm25.data.domain.City;
import com.rabbit.pm25.viewcontroller.service.ICityService;
import com.rabbit.pm25.viewcontroller.service.IDataService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Mac
 * Date: 13-8-21
 * Time: 下午8:17
 * To change this template use File | Settings | File Templates.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/applicationContext.xml",})
public class SpringTest {

    @Configuration
    static class Config {

    }

    @Autowired
    private ICityService cityService;
    @Autowired
    private IDataService dataService;

    @Test
    public void testList() {

         List<City> list = cityService.listAll();

        System.out.println("list :  \t " + list.size());

    }

    @Test
    public void testSaveOrUpdatePM25() {

        dataService.saveOrUpdatePM25();

    }



}
