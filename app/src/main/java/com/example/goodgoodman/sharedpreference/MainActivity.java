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
    PropertyUtil propertyUtil;
    final String propertyFile = "test.properties";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        propertyUtil = propertyUtil.getInstance(this);

        editName = (EditText)findViewById(R.id.editText);
        switchOnOff = (Switch)findViewById(R.id.switchOn);

        layout = (RelativeLayout)findViewById(R.id.layout2);

        if("false".equals(propertyUtil.getProperty("firstOpen"))){
            layout.setVisibility(View.GONE);
        }
    }

    public void closeHelp(View view){
        layout.setVisibility(View.GONE);
        propertyUtil.saveProperty("firstOpen", "false");
    }
    public void saveSetting(View view){

    }




}
