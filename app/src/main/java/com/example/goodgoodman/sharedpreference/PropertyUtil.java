package com.example.goodgoodman.sharedpreference;

import android.content.Context;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

/**
 * Created by GoodGoodMan on 2017. 3. 21..
 *
 * Singleton
 */

public class PropertyUtil {
    private String PROP_FILE = "sp.properties";
    private String internalStorage;
    private static PropertyUtil instance = null;
    private static Context context;

    //생성자가 호출될 때 internalStorage를 세팅해줘야 한다

    private PropertyUtil(){
        internalStorage = context.getFilesDir().getAbsolutePath();
    }
    public static PropertyUtil getInstance(Context ctx){
        context = ctx;
        if(instance == null){
            instance = new PropertyUtil();
        }
        return instance;
    }

    public void saveProperty(String key, String value){
        Properties prop = new Properties();
        prop.put(key, value);


        try {
            //앱의 내부저장소
            FileOutputStream fos = new FileOutputStream(internalStorage + "/" +PROP_FILE);
            prop.store(fos, "comment");  // firstOpen = false

            //저장완료. 파일 닫기.
            fos.close();

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public String getProperty(String key){
        String value = "";

        Properties prop = new Properties();
        try{
            FileInputStream fis = new FileInputStream(internalStorage + "/" + PROP_FILE);
            prop.load(fis);
            fis.close();

        }catch (Exception e){
            e.printStackTrace();
        }

       // prop.list(System.out); //프로퍼티 목록 전체 나열하기.

        value = prop.getProperty(key);

        return value;
    }

}
