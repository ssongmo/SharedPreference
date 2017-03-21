package com.example.goodgoodman.sharedpreference;

import android.content.Context;
import android.content.SharedPreferences;
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

        loadSetting();  //세팅된 값을 가져와 뿌린다.

    }

    public void closeHelp(View view){
        layout.setVisibility(View.GONE);
        propertyUtil.saveProperty("firstOpen", "false");
    }
    public void saveSetting(View view){
        //1. preference 생성하기
        SharedPreferences sharedPref = getPreferences(Context.MODE_PRIVATE);
        //2. SharedPreference에 값을 입력하기 위해서는 에디터를 통해서만 가능.
        SharedPreferences.Editor editor = sharedPref.edit();
        //editor.putInt("키", "값");
        editor.putString("email", editName.getText().toString());
        editor.putBoolean("onOff", switchOnOff.isChecked());
        //입력된 값을 반영.
        editor.commit();

    }
    public void loadSetting(){
        SharedPreferences sharedPref = getPreferences(Context.MODE_PRIVATE);

        String email = sharedPref.getString("email", null);
        boolean onOff = sharedPref.getBoolean("onOff", false);

        editName.setText(email);
        switchOnOff.setChecked(onOff);
    }




}
