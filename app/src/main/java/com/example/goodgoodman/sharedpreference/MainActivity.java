package com.example.goodgoodman.sharedpreference;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity {
    EditText editName;
    Switch switchOnOff;

    RelativeLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editName = (EditText)findViewById(R.id.editText);
        switchOnOff = (Switch)findViewById(R.id.switchOn);

        layout = (RelativeLayout)findViewById(R.id.layout2);

    }

    public void closeHelp(View view){
        layout.setVisibility(View.GONE);
    }
    public void saveSetting(View view){

    }
}
