package com.example.goodgoodman.sharedpreference;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Switch;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

public class MainActivity extends AppCompatActivity {
    EditText editName;
    Switch switchOnOff;

    RelativeLayout layout;
    String internalStoragePath;
    final String propertyFile = "test.properties";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        internalStoragePath = getFilesDir().getAbsolutePath();

        editName = (EditText)findViewById(R.id.editText);
        switchOnOff = (Switch)findViewById(R.id.switchOn);

        layout = (RelativeLayout)findViewById(R.id.layout2);

        if("false".equals(getProperty("firstOpen"))){
            layout.setVisibility(View.GONE);
        }
    }

    public void closeHelp(View view){
        layout.setVisibility(View.GONE);
        saveProperty("firstOpen", "false");
    }
    public void saveSetting(View view){

    }

    public void saveProperty(String key, String value){
        Properties prop = new Properties();
        prop.put(key, value);


        try {
            //앱의 내부저장소
            FileOutputStream fos = new FileOutputStream(internalStoragePath + "/test.properties");
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
            FileInputStream fis = new FileInputStream(internalStoragePath + "/" + propertyFile);
            prop.load(fis);
            fis.close();

        }catch (Exception e){
            e.printStackTrace();
        }

        prop.list(System.out); //프로퍼티 목록 전체 나열하기.

        value = prop.getProperty(key);

        return value;
    }



}
