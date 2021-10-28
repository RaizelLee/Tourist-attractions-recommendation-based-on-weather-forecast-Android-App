package com.example.raizel.a1041636_1041639_project;
/*
 Created by Raizel on 2017/12/25.
 */

//import javax.ws.rs.client.Client;
//import javax.ws.rs.core.Response;

public class weatherAPI{

    public static String [] places = {"宜蘭縣","花蓮縣","臺東縣",
            "澎湖縣","金門縣","連江縣",
            "臺北市","新北市","桃園市",
            "臺中市","臺南市","高雄市",
            "基隆市","新竹縣","新竹市",
            "苗栗縣","彰化縣","南投縣",
            "雲林縣","嘉義縣","嘉義市"};
    private static String locationName ;
    private static String dataid;
    private static String elementName;
    private static String sort;
    private static String startTime;
    private static String timeFrom;
    private static String timeTo;
    private static String AUTHORIZATION_KEY = "Authorization";
    private static String AUTHORIZATION_VALUE = "CWB-4F4A8585-E399-4BB3-A934-21CD3A459004 ";
    private static String urlString = "https://opendata.cwb.gov.tw/api/v1/rest/datastore/{"+ dataid + "}?locationName={"+ locationName + "}&elementName={"+ elementName + "}&sort={"+ sort + "}&startTime={"+ startTime + "}&timeFrom={"+ timeFrom + "}&timeTo={"+ timeTo + "}";
    //private static String result;
    //private static URL url =

    /*try {
        url = new URL(urlString);
    } catch (MalformedURLException e) {
        e.printStackTrace();
    }*/

    /*public void cwbOpendataRestClient(Client client){
        final Response response = client.target(urlString)
                .request()
                .header(AUTHORIZATION_KEY,AUTHORIZATION_VALUE).get();
        String output = response.readEntity(String.class);
        client.close();
    }*/

    /*
    private void setUsernamePassword(URL url, String result) throws IOException {
        URLConnection urlConnection = url.openConnection();
        urlConnection.setRequestProperty(AUTHORIZATION_KEY, AUTHORIZATION_VALUE);
        StringBuilder sb = new StringBuilder();
        BufferedReader reader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
        String line;
        while ((line = reader.readLine()) != null) {
            sb.append(line);
        }
        reader.close();
        result = sb.toString();
    }*/
}