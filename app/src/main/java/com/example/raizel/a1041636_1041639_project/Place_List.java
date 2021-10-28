package com.example.raizel.a1041636_1041639_project;

import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Spinner;
import android.widget.ArrayAdapter;


import java.util.List;
import java.net.URLEncoder;

//import javax.ws.rs.client.ClientBuilder;
//import javax.ws.rs.client.WebTarget;
//import java.util.concurrent.Future;

//import javax.ws.rs.client.Client;
//import javax.ws.rs.core.Response;
import org.apache.http.client.HttpClient;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import org.apache.http.HttpResponse;
import java.net.URI;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.entity.StringEntity;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ImageView;
import android.widget.Toast;
import android.app.Activity;
//import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
//import org.glassfish.jersey.client.ClientConfig;
//import org.glassfish.jersey.jackson.JacksonFeature;
//import com.sun.jersey.api.client.config.ClientConfig;
//import com.sun.jersey.client.JerseyClientBuilder;
//import com.sun.jersey.api.client.Client;
//import org.glassfish.jersey.client.authentication.HttpAuthenticationFeature;
//import com.sun.jersey.api.client.WebResource;
//import org.glassfish.jersey.client.ClientRequest;
//import org.glassfish.jersey.client.ClientResponse;
/*import com.sun.jersey.api.client.ClientResponse;
//import com.sun.jersey.api.client.WebResource;*/
import android.util.Log;
import java.io.InputStream;
import android.graphics.Bitmap;
import 	android.graphics.BitmapFactory;
import java.net.URL;
import android.os.StrictMode;
import 	android.graphics.drawable.Drawable;

public class Place_List extends AppCompatActivity {

    protected placeItem placeItem;
    protected Spinner PlaceList;
    protected List<placeItem> result;
    private static String re;
    private int a;

    public static String [] places = {"宜蘭縣","花蓮縣","臺東縣",//0.1.2
            "澎湖縣","金門縣","連江縣", //3.4.5
            "臺北市","新北市","桃園市", //6.7.8
            "臺中市","臺南市","高雄市", //9.10.11
            "基隆市","新竹縣","新竹市", //12.13.14
            "苗栗縣","彰化縣","南投縣", //15.16.17
            "雲林縣","嘉義縣","嘉義市"}; //18.19.20
    private static String locationName=places[9];
    private static String dataid="F-C0032-001";
    private static String elementName="Wx";
    private static String sort="time";
    private static String startTime="2017-02-06T12:00:00";
    private static String timeFrom="2017-02-06T18:00:00";
    private static String timeTo="2017-02-06T20:00:00";
    private static String AUTHORIZATION_KEY = "Authorization";
    private static String AUTHORIZATION_VALUE = "CWB-26E7EBFA-E4FE-4449-86A7-D71EFD441AE2";
    private static String urlString = "https://opendata.cwb.gov.tw/api/v1/rest/datastore/%7B"+ URLEncoder.encode(dataid) + "%7D?locationName=%7B"+ URLEncoder.encode(locationName) + "%7D&elementName=%7B"+ URLEncoder.encode(elementName) + "%7D&sort=%7B"+ sort + "%7D&startTime=%7B"+ URLEncoder.encode(startTime) + "%7D&timeFrom=%7B"+ URLEncoder.encode(timeFrom) + "%7D&timeTo=%7B"+ URLEncoder.encode(timeTo) + "%7D";
    //private static String url;
    //private static String urlString = "https://opendata.cwb.gov.tw/api/v1/rest/datastore/"+ URLEncoder.encode("{") + URLEncoder.encode(dataid) + URLEncoder.encode("}") +"?locationName="+ URLEncoder.encode("{") + URLEncoder.encode(locationName) +  URLEncoder.encode("}") +"&elementName="+ URLEncoder.encode("{") + URLEncoder.encode(elementName) + URLEncoder.encode("}") + "&sort="+ URLEncoder.encode("{") + sort +  URLEncoder.encode("}") +"&startTime="+ URLEncoder.encode("{") + URLEncoder.encode(startTime) +  URLEncoder.encode("}") +"&timeFrom="+ URLEncoder.encode("{") + URLEncoder.encode(timeFrom) +  URLEncoder.encode("}") +"&timeTo="+ URLEncoder.encode("{") + URLEncoder.encode(timeTo) + URLEncoder.encode("}") ;


    //Client client = ClientBuilder.Client();
    protected TextView listName001;
    protected TextView listName002;
    protected TextView listName003;
    protected TextView listName004;
    protected TextView listName005;
    protected ImageView listPic001;
    protected ImageView listPic002;
    protected ImageView listPic003;
    protected ImageView listPic004;
    protected ImageView listPic005;
    //protected Drawable myDrawable = getResources()




    //private static Client client = ClientBuilder.newClient();
    //= new URL(urlString);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place_list);
        placeItem = new placeItem(getApplicationContext());
        result = placeItem.getAll();
        if (result.size() == 0) {
            placeItem.start();
        }
        /*PlaceList = (Spinner) findViewById(R.id.PlaceList);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, new String[]{
                "所有地區", "臺北市", "新北市", "桃園市",
                "臺中市", "臺南市", "高雄市", "基隆市",
                "新竹縣", "新竹市", "宜蘭縣", "花蓮縣",
                "臺東縣", "雲林縣", "嘉義縣", "嘉義市", "苗栗縣", "彰化縣", "南投縣", "澎湖縣", "金門縣", "連江縣"});
        PlaceList.setAdapter(adapter);
        listName001 = (TextView) findViewById(R.id.place001T);
        listName002 = (TextView) findViewById(R.id.place002T);
        listName003 = (TextView) findViewById(R.id.place003T);
        listName004 = (TextView) findViewById(R.id.place004T);
        listName005 = (TextView) findViewById(R.id.place005T);
        listPic001 = (ImageView) findViewById(R.id.place001P);
        listPic002 = (ImageView) findViewById(R.id.place002P);
        listPic003 = (ImageView) findViewById(R.id.place003P);
        listPic004 = (ImageView) findViewById(R.id.place004P);
        listPic005 = (ImageView) findViewById(R.id.place005P);
        listPic001.setImageResource(R.drawable.a);
        listPic002.setImageResource(R.drawable.b);
        listPic003.setImageResource(R.drawable.c);
        listPic004.setImageResource(R.drawable.d);
        listPic005.setImageResource(R.drawable.e);
        for(int i=0; i<result.size();i++){
            if(i==0){
                listName001.setText(result.get(i).getPlaceName());
            }
            else if(i==1){
                listName002.setText(result.get(i).getPlaceName());
            }
            else if(i==2){
                listName003.setText(result.get(i).getPlaceName());
            }
            else if(i==3){
                listName004.setText(result.get(i).getPlaceName());
            }
            else if(i==4){
                listName005.setText(result.get(i).getPlaceName());
            }
        }
        //list001.setText(result[0]);
        cwbOpendataRestClient();

    }


    public void cwbOpendataRestClient(){
        //clientConfig.register(feature);
        //clientConfig.register(JacksonFeature.class);
        InputStream inputStream = null;
        String result = "";
        try {
            //url = URLEncoder.encode(urlString, "UTF-8");
            // create HttpClient
            HttpClient httpclient = new DefaultHttpClient();
            HttpGet hp= new HttpGet(urlString);
            hp.setHeader(AUTHORIZATION_KEY,AUTHORIZATION_VALUE);
            // make GET request to the given URL
            try {
                HttpResponse httpResponse = httpclient.execute(hp);
                inputStream = httpResponse.getEntity().getContent();
            }catch (Exception e) {
                Log.e("READ_PLACES_ERROR\n\n\n", e.toString());
            }
            //httpResponse.setHeader(AUTHORIZATION_KEY,AUTHORIZATION_VALUE);

            // receive response as inputStream

            // convert inputstream to string
            if(inputStream != null){
                result = convertInputStreamToString(inputStream);
                Log.v("result:\n\n\n",result);
            }
            else
                result = "Did not work!";

        } catch (Exception e) {
            Log.d("InputStream", e.getLocalizedMessage());
        }
        Log.v("result:\n\n\n",result);



        //
        /*DefaultHttpClient httpclient = new DefaultHttpClient();
        try {
            url = URLEncoder.encode(urlString, "UTF-8");
            HttpPost httppost = new HttpPost(url);
            StringEntity httpPostEntity = new StringEntity("100", "UTF_8");
            httppost.setEntity(httpPostEntity);
            httppost.setHeader("host",url);
            httppost.setHeader("scheme","https");
            httppost.setHeader(AUTHORIZATION_KEY, AUTHORIZATION_VALUE);
            System.out.println("executing request " + httppost.getRequestLine());
            HttpResponse response;
            try {
                response = httpclient.execute(httppost);
                HttpEntity entity = response.getEntity();
            } catch (ClientProtocolException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }*/
        //ClientConfig clientConfig = new ClientConfig();
        //HttpAuthentication feature = HttpAuthenticationFeature.basic(AUTHORIZATION_KEY, AUTHORIZATION_VALUE);
        //Client client = Client.create();
        //HttpAuthenticationFeature feature = HttpAuthenticationFeature.basic("username", "password");
        //final Client client = ClientBuilder.newClient();
        //client.register(feature);
        //WebResource webResource = client.resource(urlString);
        //String s = webResource.get(String.class);
        //Log.v("s:\n\n\n",s);
        /*final ClientResponse response = client.resource(urlString)
                .header(AUTHORIZATION_KEY,AUTHORIZATION_VALUE);
        output = response.readEntity(String.class);
        client.close();
        Log.v("output:\n\n\n",output);*/
    }
    private static String convertInputStreamToString(InputStream inputStream) throws IOException{
        BufferedReader bufferedReader = new BufferedReader( new InputStreamReader(inputStream));
        String line = "";
        String result = "";
        while((line = bufferedReader.readLine()) != null)
            result += line;

        inputStream.close();
        return result;

    }

}
