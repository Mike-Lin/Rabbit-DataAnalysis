package com.rabbit.pm25.viewcontroller.service;

import com.rabbit.pm25.data.domain.City;
import com.rabbit.pm25.data.domain.PM25;
import com.rabbit.pm25.data.domain.Station;
import com.rabbit.pm25.viewcontroller.dao.ICityDao;
import com.rabbit.pm25.viewcontroller.dao.IPM25Dao;
import com.rabbit.pm25.viewcontroller.dao.IStationDao;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Mac
 * Date: 13-8-20
 * Time: 下午11:55
 * To change this template use File | Settings | File Templates.
 */
@Service("pm25Service")
public class PM25Service implements IPM25Service {


    @Autowired
    private IPM25Dao pm25Dao;
    @Autowired
    private IStationDao stationDao;
    @Autowired
    private ICityDao cityDao;



    public List<PM25> listByCity(String city) {

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

                List<Station> stationList = stationDao.queryWithHQL(" from " + Station.class.getSimpleName() + " where name like ? ", new String[]{jo.getString("position_name")});

                if (stationList != null && stationList.size() > 0) {

                    Station station = stationList.get(0);
                    pm25.setStation(station);

                }

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

    @Override
    public void saveCurrentPM25() {

        List<City> cities = cityDao.queryAll();

        for (City city : cities) {

            List<PM25> list = listByCity(city.getName());

            pm25Dao.batchInsert(list);

        }

    }
}
