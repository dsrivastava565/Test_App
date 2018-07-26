package com.example.my_dell.test_app;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class User_Portal extends AppCompatActivity {
    TextView t1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user__portal);
        t1=(TextView)findViewById(R.id.Name_Print);
        SharedPreferences sharedPreferences=getSharedPreferences("MyData",MODE_PRIVATE);
        String name= sharedPreferences.getString("Name","N/A");
        t1.setText(name);
    }
}
