//import com.rabbit.pm25.data.AnalyzeData;
//import com.rabbit.pm25.data.domain.PM25;
//import com.rabbit.pm25.data.domain.Station;
//import junit.framework.TestCase;
//
//import java.util.List;
//
///**
// * Created with IntelliJ IDEA.
// * User: Mac
// * Date: 13-8-18
// * Time: 上午1:06
// * To change this template use File | Settings | File Templates.
// */
//public class TestData extends TestCase {
//
//    public void setUp() {
//        System.out.println("setUp\t");
//    }
//
//    public void tearDown() {
//        System.out.println("tearDown\t");
//    }
//
//    public void testSaveCities() {
//
//        AnalyzeData analyzeData = new AnalyzeData();
//        analyzeData.saveOrUpdateCities();
//
//    }
//
//    public void testSavePm25() {
//
//        AnalyzeData analyzeData = new AnalyzeData();
//        analyzeData.saveOrUpdatePM25();
//
//    }
//
//    public void testQueryPm25ByCity() {
//
//
//
//    }
//
//    public void testQueryPm25ByStation() {
//
//        StationDao stationDao = new StationDao();
//        Station station = stationDao.getByName("劳动公园");
//
//        PM25Dao pm25Dao = new PM25Dao();
//        List<PM25> pm25List = pm25Dao.queryByStation(station);
//
//
//    }
//
//    public void testQueryPm25ByTime() {
//
//        PM25Dao pm25Dao = new PM25Dao();
//        List<PM25> pm25List = pm25Dao.queryByTime("");
//
//    }
//
//}
