package com.rabbit.pm25.data;


import com.rabbit.pm25.data.domain.City;
import com.rabbit.pm25.data.domain.PM25;
import com.rabbit.pm25.data.domain.Station;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Mac
 * Date: 13-7-30
 * Time: 下午8:25
 * To change this template use File | Settings | File Templates.
 */


public class AnalyzeData {

    private final String BASE_URL = "http://www.pm25.in/api/";
    // 1.10、获取所有城市的监测点列表（每小时10次）
    private final String station_names_url = "querys/station_names.json";
    // 1.11、获取实施了新《环境空气质量标准》的城市列表，即有PM2.5数据的城市列表（每小时10次）
    private final String detail_url = "api/querys.json";
    // 1.12、获取所有城市的空气质量详细数据（每小时5次）
    private final String all_cities_url = "querys/all_cities.json";
    // 1.13、获取全部城市的空气质量指数(AQI)排行榜（每小时15次）
    private final String aqi_ranking_url = "querys/aqi_ranking.json";
    private final String appkey_release = "YJJM8siP67fmnMJyGmNP";
    private final String appkey_dev = "5j1znBVAsnSf5xQyNQyq";


    public void saveData() {

        DefaultHttpClient httpclient = new DefaultHttpClient();
        HttpGet httpget = new HttpGet("http://www.pm25.in/api/querys/pm2_5.json?city=珠海&token=5j1znBVAsnSf5xQyNQyq");

        try {

            // Create a response handler
            ResponseHandler<String> responseHandler = new BasicResponseHandler();
            String responseBody = httpclient.execute(httpget, responseHandler);

            JSONArray jsonArray = new JSONArray(responseBody);

        } catch (JSONException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (ClientProtocolException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } finally {
            // When HttpClient instance is no longer needed,
            // shut down the connection manager to ensure
            // immediate deallocation of all system resources
            httpclient.getConnectionManager().shutdown();
        }

    }

    public static List<City> citys() {

        List<City> list = new ArrayList<City>();

        DefaultHttpClient httpclient = new DefaultHttpClient();
        HttpGet httpget = new HttpGet("http://www.pm25.in/api/querys/station_names.json?token=5j1znBVAsnSf5xQyNQyq");

        try {

            // Create a response handler
            ResponseHandler<String> responseHandler = new BasicResponseHandler();
            String responseBody = httpclient.execute(httpget, responseHandler);

            JSONArray jsonArray = new JSONArray(responseBody);
            for (int i=0 ; i<jsonArray.length(); i++) {

                JSONObject jo = (JSONObject) jsonArray.get(i);

                City c = new City();
                c.setName(jo.getString("city"));


                JSONArray ja = jo.getJSONArray("stations");
                for (int y=0; y < ja.length(); y++) {

                    JSONObject jsonObject = (JSONObject) ja.get(y);

                    Station s = new Station();
                    s.setCode(jsonObject.getString("station_code"));
                    s.setName(jsonObject.getString("station_name"));

                    c.getStations().add(s);

                    s.setCity(c);

                }

                list.add(c);

            }

            return list;

        } catch (JSONException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (ClientProtocolException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } finally {
            // When HttpClient instance is no longer needed,
            // shut down the connection manager to ensure
            // immediate deallocation of all system resources
            httpclient.getConnectionManager().shutdown();
        }

        return null;
    }

    public static List<PM25> listByCity(String city) {

        List<PM25> list = new ArrayList<PM25>();

        DefaultHttpClient httpclient = new DefaultHttpClient();
        HttpGet httpget = new HttpGet("http://www.pm25.in/api/querys/aqi_details.json?token=5j1znBVAsnSf5xQyNQyq&city="+city);

        try {

            // Create a response handler
            ResponseHandler<String> responseHandler = new BasicResponseHandler();
            String responseBody = httpclient.execute(httpget, responseHandler);

            JSONArray jsonArray = new JSONArray(responseBody);
            for (int i=0 ; i<jsonArray.length(); i++) {

                JSONObject jo = (JSONObject) jsonArray.get(i);

                PM25 pm25 = new PM25();
                pm25.setAqi(jo.getString("aqi"));
                pm25.setPositionName(jo.getString("position_name"));
                pm25.setStationCode(jo.getString("station_code"));
                pm25.setSo2(jo.getString("so2"));
                pm25.setSo2_24h(jo.getString("so2_24h"));
                pm25.setNo2(jo.getString("no2"));
                pm25.setNo2_24h(jo.getString("no2_24h"));
                pm25.setPm10(jo.getString("pm10"));
                pm25.setPm10_24h(jo.getString("pm10_24h"));
                pm25.setCo(jo.getString("co"));
                pm25.setCo_24h(jo.getString("co_24h"));
                pm25.setO3(jo.getString("o3"));
                pm25.setO3_24h(jo.getString("o3_24h"));
                pm25.setO3_8h(jo.getString("o3_8h"));
                pm25.setO3_8h_24h(jo.getString("o3_8h_24h"));
                pm25.setPm2_5(jo.getString("pm2_5"));
                pm25.setPm2_5_24h(jo.getString("pm2_5_24h"));
                pm25.setPrimaryPollutant(jo.getString("primary_pollutant"));
                pm25.setQuality(jo.getString("quality"));
                pm25.setTimePoint(jo.getString("time_point"));

                // Station
//                StationDao stationDao = new StationDao();
//                Station station = stationDao.getByName(jo.getString("position_name"));
//                pm25.setStation(station);

                list.add(pm25);

            }

            return list;

        } catch (JSONException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (ClientProtocolException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } finally {
            // When HttpClient instance is no longer needed,
            // shut down the connection manager to ensure
            // immediate deallocation of all system resources
            httpclient.getConnectionManager().shutdown();
        }

        return null;
    }
//
//    public void saveOrUpdateCities() {
//
//        List<City> cities = citys();
//
//        ICityDao cityDao = new CityDao();
//        cityDao.batchInsert(cities);
//
//
//    }
//
//    public void saveOrUpdatePM25() {
//
//        CityDao cityDao = new CityDao();
//
//        PM25Dao dao = new PM25Dao();
//
//        List<City> cities = cityDao.queryAll();
//
//        for (City city : cities) {
//
//            dao.batchSave(listByCity(city.getName()));
//
//        }
//
//    }

    public static void main(String[] args) throws Exception {


    }

    public List<PM25> queryByCity(City city) {



        return null;
    }

    public List<PM25> queryByStation(Station station) {



        return null;
    }
}
