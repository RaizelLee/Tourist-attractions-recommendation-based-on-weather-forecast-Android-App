package com.example.raizel.a1041636_1041639_project;

/**
 * Created by Raizel on 2017/12/24.
 */

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import	android.graphics.Bitmap;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

// 資料功能類別
public class placeItem {
    // 表格名稱
    private int ID;//0
    private String placeName; //1
    private String location; //2
    private double xCoor; //3
    private double yCoor; //4
    private String intro; //5
    private String money; //6
    private String time; //7
    private String tele; //8
    private String address; //9
    private String pic; //10
    private String web; //11
    private int sunny; //12
    private int rain; //13
    private int cold; //14
    private int cozy; //15
    private int hot;

    public static final String TABLE_NAME = "placeItems";

    // 編號表格欄位名稱，固定不變
    private static final String KEY_ID = "_id"; //0

    // 其它表格欄位名稱
    private static final String PLACENAME_COLUMN = "placename"; //1
    private static final String LOCATION_COLUMN = "location"; //2
    private static final String XCOOR_COLUMN = "xcoor"; //3
    private static final String YCOOR_COLUMN = "ycoor"; //4
    private static final String INTRO_COLUMN = "intro"; //5
    private static final String MONEY_COLUMN = "money"; //6
    private static final String TIME_COLUMN = "time"; //7
    private static final String TELE_COLUMN = "tele"; //8
    private static final String ADDRESS_COLUMN = "address"; //9
    private static final String PIC_COLUMN = "pic"; //10
    private static final String WEB_COLUMN = "web"; //11
    private static final String SUNNY_COLUMN = "sunny"; //12
    private static final String RAIN_COLUMN = "rain"; //13
    private static final String COLD_COLUMN = "cold"; //14
    private static final String COZY_COLUMN = "cozy"; //15
    private static final String HOT_COLUMN = "hot"; //16

    // 使用上面宣告的變數建立表格的SQL指令
    public static final String CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME + " (" +
                    KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + //0
                    PLACENAME_COLUMN + " TEXT NOT NULL, " + //1
                    LOCATION_COLUMN + " TEXT NOT NULL, " + //2
                    XCOOR_COLUMN + " REAL, " + //3
                    YCOOR_COLUMN + " REAL, " + //4
                    INTRO_COLUMN + " TEXT NOT NULL, " + //5
                    MONEY_COLUMN + " TEXT NOT NULL, " + //6
                    TIME_COLUMN + " TEXT NOT NULL, " + //7
                    TELE_COLUMN + " TEXT NOT NULL, " + //8
                    ADDRESS_COLUMN + " TEXT NOT NULL, " + //9
                    PIC_COLUMN + " TEXT NOT NULL, " + //10
                    WEB_COLUMN + " TEXT NOT NULL, " + //11
                    SUNNY_COLUMN + " INTEGER NOT NULL, " + //12
                    RAIN_COLUMN + " INTEGER NOT NULL, " + //13
                    COLD_COLUMN + " INTEGER NOT NULL, " + //14
                    COZY_COLUMN + " INTEGER NOT NULL, " + //15
                    HOT_COLUMN + " INTEGER NOT NULL)"; //16

    // 資料庫物件
    private SQLiteDatabase db;
    public placeItem(){};
    public placeItem(int id,String pn,String l,double x,double y,String i,String m,String ti,String te,String add,String p,String w,int s,int r,int col,int coz,int h){
        ID=id;//0
        placeName=pn; //1
        location=l; //2
        xCoor=x; //3
        yCoor=y; //4
        intro=i; //5
        money=m; //6
        time=ti; //7
        tele=te; //8
        address=add; //9
        pic=p; //10
        web=w; //11
        sunny=s; //12
        rain=r; //13
        cold=col; //14
        cozy=coz; //15
        hot=h;
    }

    // 建構子，一般的應用都不需要修改
    public placeItem(Context context) {
        db = placeLib.getDatabase(context);
    }

    // 關閉資料庫，一般的應用都不需要修改
    public void close() {
        db.close();
    }

    // 新增參數指定的物件
    public placeItem insert(placeItem aPlace) {
        // 建立準備新增資料的ContentValues物件
        ContentValues cv = new ContentValues();

        // 加入ContentValues物件包裝的新增資料
        // 第一個參數是欄位名稱， 第二個參數是欄位的資料
        cv.put(KEY_ID, aPlace.getID());//0
        cv.put(PLACENAME_COLUMN, aPlace.getPlaceName()); //1
        cv.put(LOCATION_COLUMN, aPlace.getLocation()); //2
        cv.put(XCOOR_COLUMN, aPlace.getXCoor()); //3
        cv.put(YCOOR_COLUMN, aPlace.getYCoor()); //4
        cv.put(INTRO_COLUMN, aPlace.getIntro()); //5
        cv.put(MONEY_COLUMN, aPlace.getMoney()); //6
        cv.put(TIME_COLUMN, aPlace.getTime()); //7
        cv.put(TELE_COLUMN, aPlace.getTele()); //8
        cv.put(ADDRESS_COLUMN, aPlace.getAddress()); //9
        cv.put(PIC_COLUMN, aPlace.getPic()); //10
        cv.put(WEB_COLUMN, aPlace.getWeb()); //11
        cv.put(SUNNY_COLUMN, aPlace.getSunny()); //12
        cv.put(RAIN_COLUMN, aPlace.getRain()); //13
        cv.put(COLD_COLUMN , aPlace.getCold()); //14
        cv.put(COZY_COLUMN, aPlace.getCozy()); //15
        cv.put(HOT_COLUMN, aPlace.getHot()); //16

        // 新增一筆資料並取得編號
        // 第一個參數是表格名稱
        // 第二個參數是沒有指定欄位值的預設值
        // 第三個參數是包裝新增資料的ContentValues物件
        //long id =
        db.insert(TABLE_NAME, null, cv);
        //Log.v("db:\n\n\n",db.toString());

        // 設定編號
        //placeItem.setId(id);/////
        // 回傳結果
        return aPlace;
    }

    // 修改參數指定的物件
    public boolean update(placeItem aPlace) {
        // 建立準備修改資料的ContentValues物件
        ContentValues cv = new ContentValues();

        // 加入ContentValues物件包裝的修改資料
        // 第一個參數是欄位名稱， 第二個參數是欄位的資料
        cv.put(KEY_ID, aPlace.getID());//0
        cv.put(PLACENAME_COLUMN, aPlace.getPlaceName()); //1
        cv.put(LOCATION_COLUMN, aPlace.getLocation()); //2
        cv.put(XCOOR_COLUMN, aPlace.getXCoor()); //3
        cv.put(YCOOR_COLUMN, aPlace.getYCoor()); //4
        cv.put(INTRO_COLUMN, aPlace.getIntro()); //5
        cv.put(MONEY_COLUMN, aPlace.getMoney()); //6
        cv.put(TIME_COLUMN, aPlace.getTime()); //7
        cv.put(TELE_COLUMN, aPlace.getTele()); //8
        cv.put(ADDRESS_COLUMN, aPlace.getAddress()); //9
        cv.put(PIC_COLUMN, aPlace.getPic()); //10
        cv.put(WEB_COLUMN, aPlace.getWeb()); //11
        cv.put(SUNNY_COLUMN, aPlace.getSunny()); //12
        cv.put(RAIN_COLUMN, aPlace.getRain()); //13
        cv.put(COLD_COLUMN , aPlace.getCold()); //14
        cv.put(COZY_COLUMN, aPlace.getCozy()); //15
        cv.put(HOT_COLUMN, aPlace.getHot()); //16

        // 設定修改資料的條件為編號
        // 格式為「欄位名稱＝資料」
        String where = KEY_ID + "=" + aPlace.getID();

        // 執行修改資料並回傳修改的資料數量是否成功
        return db.update(TABLE_NAME, cv, where, null) > 0;
    }

    // 刪除參數指定編號的資料
    public boolean delete(int id){
        // 設定條件為編號，格式為「欄位名稱=資料」
        String where = KEY_ID + "=" + id;
        // 刪除指定編號資料並回傳刪除是否成功
        return db.delete(TABLE_NAME, where , null) > 0;
    }

    // 讀取所有記事資料
    public List<placeItem> getAll() {
        List<placeItem> result = new ArrayList<>();
        Cursor cursor = db.query(
                TABLE_NAME, null, null, null, null, null, null, null);

        while (cursor.moveToNext()) {
            result.add(getRecord(cursor));
        }

        cursor.close();
        return result;
    }
    // 取得指定編號的資料物件
    /*public Item get(long id) {
        // 準備回傳結果用的物件
        Item item = null;
        // 使用編號為查詢條件
        String where = KEY_ID + "=" + id;
        // 執行查詢
        Cursor result = db.query(
                TABLE_NAME, null, where, null, null, null, null, null);

        // 如果有查詢結果
        if (result.moveToFirst()) {
            // 讀取包裝一筆資料的物件
            item = getRecord(result);
        }

        // 關閉Cursor物件
        result.close();
        // 回傳結果
        return item;
    }*/

    // 把Cursor目前的資料包裝為物件
    public placeItem getRecord(Cursor cursor) {
        // 準備回傳結果用的物件
        placeItem result = new placeItem();

        result.setID(cursor.getInt(0)); //0
        result.setPlaceName(cursor.getString(1)); //1
        result.setLocation(cursor.getString(2)); //2
        result.setXCoor(cursor.getDouble(3)); //3
        result.setYCoor(cursor.getDouble(4)); //4
        result.setIntro(cursor.getString(5)); //5
        result.setMoney(cursor.getString(6)); //6
        result.setTime(cursor.getString(7)); //7
        result.setTele(cursor.getString(8)); //8
        result.setAddress(cursor.getString(9)); //9
        result.setPic(cursor.getString(10)); //10
        result.setWeb(cursor.getString(11)); //11
        result.setSunny(cursor.getInt(12)); //12
        result.setRain(cursor.getInt(13)); //13
        result.setCold(cursor.getInt(14)); //14
        result.setCozy(cursor.getInt(15)); //15
        result.setHot(cursor.getInt(16)); //16
        // 回傳結果
        return result;
    }

    // 取得資料數量
    /*public int getCount() {
        int result = 0;
        Cursor cursor = db.rawQuery("SELECT COUNT(*) FROM " + TABLE_NAME, null);

        if (cursor.moveToNext()) {
            result = cursor.getInt(0);
        }

        return result;
    }*/

    // 建立範例資料
    /*public void sample() {
        placeItem item = new placeItem(0, new Date().getTime(), Colors.RED, "關於Android Tutorial的事情.", "Hello content", "", 0, 0, 0);
        placeItem item2 = new placeItem(0, new Date().getTime(), Colors.BLUE, "一隻非常可愛的小狗狗!", "她的名字叫「大熱狗」，又叫\n作「奶嘴」，是一隻非常可愛\n的小狗。", "", 25.04719, 121.516981, 0);
        placeItem item3 = new placeItem(0, new Date().getTime(), Colors.GREEN, "一首非常好聽的音樂！", "Hello content", "", 0, 0, 0);
        placeItem item4 = new placeItem(0, new Date().getTime(), Colors.ORANGE, "儲存在資料庫的資料", "Hello content", "", 0, 0, 0);

        insert(item);
        insert(item2);
        insert(item3);
        insert(item4);
    }*/

    public int getID() //0
    {
        return ID;
    }
    public String getPlaceName() //1
    {
        return placeName;
    }
    public String getLocation() //2
    {
        return location;
    }
    public double getXCoor() //3
    {
        return xCoor;
    }
    public double getYCoor() //4
    {
        return yCoor;
    }
    public String getIntro() //5
    {
        return intro;
    }
    public String getMoney() //6
    {
        return money;
    }
    public String getTime() //7
    {
        return time;
    }
    public String getTele() //8
    {
        return tele;
    }
    public String getAddress() //9
    {
        return address;
    }
    public String getPic() //10
    {
        return pic;
    }
    public String getWeb() //11
    {
        return web;
    }
    public int getSunny() //12
    {
        return sunny;
    }
    public int getRain() //13
    {
        return rain;
    }
    public int getCold() //14
    {
        return cold;
    }
    public int getCozy() //15
    {
        return cozy;
    }
    public int getHot() //16
    {
        return hot;
    }

    public void setID(int id) //0
    {
        ID = id;
    }
    public void setPlaceName(String pn) //1
    {
        placeName=pn;
    }
    public void setLocation(String l) //2
    {
        location =l;
    }
    public void setXCoor(double x) //3
    {
        xCoor = x;
    }
    public void setYCoor(double y) //4
    {
        yCoor = y;
    }
    public void setIntro(String i) //5
    {
        intro = i;
    }
    public void setMoney(String i) //6
    {
        money = i;
    }
    public void setTime(String i) //7
    {
        time = i;
    }
    public void setTele(String i) //8
    {
        tele = i;
    }
    public void setAddress(String i) //9
    {
        address = i;
    }
    public void setPic(String i) //10
    {
        pic = i;
    }
    public void setWeb(String i) //11
    {
        web = i;
    }
    public void setSunny(int i) //12
    {
        sunny = i;
    }
    public void setRain(int i) //13
    {
        rain = i;
    }
    public void setCold(int i) //14
    {
        cold = i;
    }
    public void setCozy(int i) //15
    {
        cozy = i;
    }
    public void setHot(int i) //16
    {
        hot = i;
    }

    public void start(){
        insert(new placeItem(1,"光復新村","台中縣",24.04501,120.694512,"位於霧峰區的光復新村，是早期台灣第一個新市鎮，濃厚的眷村味，是拍攝婚紗取景的好去處，也有不少電影也在此取景，因此近期成為民眾的熱門觀光景點。","免費","每日24小時皆開放","04-2229-0280#502","台中市霧峰區坑口里光復新村","http://iphoto.ipeen.com.tw/photo/comment/201602/cgmd67da4e8baae3d0affd1e65767741e10828.jpg","https://goo.gl/Qf5Ti9",1,0,1,1,0));
        insert(new placeItem(2,"高美野生動物保護區","台中縣",24.312068,120.549796,"高美濕地位於清水大甲溪出海口南側，擁有豐富的天然資源，是國內少數幾處雁鴨集體繁殖區之一。目前已逐漸取代大肚溪口，成為喜好賞鳥人士的新興賞線。","免費","每日24小時皆開放","04-2656-5810","臺中市清水區大甲溪出海口高美濕地","https://3.bp.blogspot.com/-RU-PPGu2Qmw/WIyy6kFIgXI/AAAAAAADJgM/x9I4hN5RoT43EKyEbN7hsXofNV6Desb5ACLcB/s1600/IMG_7757_%25E7%25B5%2590%25E6%259E%259C.JPG","http://www.gaomei.com.tw/",1,0,0,1,0));
        insert(new placeItem(3,"勤美誠品綠園道","台中縣",24.151262,120.6637,"勤美誠品綠園道，是由一座包覆著鐵皮的半廢棄的停車場大樓，經由精心改造後，所建而成。也因在改造期間以植造等方式建造，讓植栽可以循環自生、無須更換，還成為許多花鳥蝴蝶的家，也成為自然人文新地標，不但榮獲2009國家卓越建設，更代表台灣榮獲素有不動產屆奧斯卡獎之稱的「2010年全球卓越建築獎」。","免費","每日24小時皆開放","04-2328-1000","臺中市西區公益路68號","http://www.formosaimage.com/gallery2/main.php?g2_view=core.DownloadItem&g2_itemId=38334&g2_serialNumber=2","http://www.parklane.com.tw/",1,1,1,1,1));
        insert(new placeItem(4,"臺中國家歌劇院","台中縣",24.163068,120.641263,"建築師 伊東豊雄說「我一直在尋求創造有如河流上漣漪一般的建築，一個既能與流動的河流維持關係，又同時保有自我的空間。」因此打破傳統音樂廳穩定、封閉的結構，歌劇院建築幾乎全由曲牆構成，牆與天花板所定義的空間都是流動且沒有邊界，人們能自由地舉辦各種活動。","依每次活動定價，詳情請洽官方","週日至週四 11：30 ～ 21：00 週五至週六及國定假日 11：30 ～ 22：00","04 2251-1777","台中市西屯區惠來路二段101號","https://farm9.staticflickr.com/8138/15776875236_17237c71ae_b.jpg","http://www.npac-ntt.org/index",1,1,1,1,1));
        insert(new placeItem(5,"國立自然科學博物館","台中縣",24.157008,120.666028,"國立自然科學博物館位於臺中市北區，為國家設立的第一座科學博物館，也是首座將自然科學生活化的博物館，亦是一處可以實地動手操作學習的知識殿堂。","依不同劇場收費不同，以現場價格為主","週一 休息\n週二~週日 09:00–17:00","04 2322-6940","台中市北區館前路1號","https://www.taiwan.net.tw/att/1/big_scenic_spots/pic_2191_6.jpg","http://www.nmns.edu.tw/",1,1,1,1,1));
    }


    /*public void insertImg(Bitmap img) {


        byte[] data = getBitmapAsByteArray(img); // this is a function
        insertStatement_logo.bindBlob(2, data);

        insertStatement_logo.executeInsert();
        insertStatement_logo.clearBindings() ;

    }

    public static byte[] getBitmapAsByteArray(Bitmap bitmap) {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        bitmap.compress(CompressFormat.PNG, 0, outputStream);
        return outputStream.toByteArray();
    }*/
}