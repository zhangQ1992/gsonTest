package com.example.qing.gsontest;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.gson.Gson;

public class MainActivity extends Activity {

    final static String LOG_TAG = "GSON-------";
    private EditText mEditText;
    private Button mButton;
    private EditText mTextView;
    private String s;

    private Person mPerson = new Person();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mButton = (Button) findViewById(R.id.btn);
        mEditText = (EditText) findViewById(R.id.et);
        mTextView = (EditText) findViewById(R.id.tv);
        mPerson.name = "zhangq";
        mPerson.age = 27;
        mPerson.sex = "male";
        mPerson.addr = "GuangZhou,Kexuecheng.Street 123.xxxx xxxx";
        mPerson.Engineer = true;
        mPerson.tel = "18825052624";


        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Gson mGson = new Gson();
                if(mEditText.getText().length() == 0) {
                    s = mGson.toJson(mPerson);
                    mTextView.setText(s);
                    Log.d(LOG_TAG,"json:"+ s);
                } else {
                    s = mEditText.getText().toString();
                    Person xPerson;
                    xPerson = mGson.fromJson(s, Person.class);
                    Log.d(LOG_TAG,"name:"+ xPerson.name);
                    Log.d(LOG_TAG,"age:"+ xPerson.age);
                    Log.d(LOG_TAG,"sex:"+ xPerson.sex);
                    Log.d(LOG_TAG,"addr:"+ xPerson.addr);
                    Log.d(LOG_TAG,"tel:"+ xPerson.tel);
                    Log.d(LOG_TAG,"engineer:"+ xPerson.Engineer);
                    String x = String.format(   "name:         "+ xPerson.name+
                                                "\r\nage:      "+ xPerson.age+
                                                "\r\nsex:      "+ xPerson.sex+
                                                "\r\naddr:     "+ xPerson.addr+
                                                "\r\ntel:      "+ xPerson.tel+
                                                "\r\nengineer: "+ xPerson.Engineer);
                    mTextView.setText(x);
                }

            }
        });
    }
}

