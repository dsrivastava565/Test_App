package com.example.my_dell.test_app;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button signup,submit;
    String forUser,forPassword;
    EditText Username,Password;
  //  CardView cardView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        signup=(Button)findViewById(R.id.save_area);
        submit=(Button)findViewById(R.id.submit_area1);
        Username=(EditText)findViewById(R.id.username);
        Password=(EditText)findViewById(R.id.password);
       // cardView=(CardView)findViewById(R.id.card_view);
      //  cardView.setCardElevation(300);
        //cardView.setRadius(5);
        OnButtonClick();
        OnSubmitClick();
    }

    public void OnButtonClick()
    {
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext() ,Usersave.class);
                startActivity(intent);
                finish();
            }
        });

    }
    public void OnSubmitClick()
    {
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sharedPreferences=getSharedPreferences("MyData",MODE_PRIVATE);
                String name = sharedPreferences.getString("username","N/A");
                String pass=sharedPreferences.getString("password","N/A");
                forUser=Username.getText().toString();
                forPassword=Password.getText().toString();
                if (name.equals(forUser) && pass.equals(forPassword))
                {

                    Toast.makeText(getApplicationContext(),"Perfect",Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(getApplicationContext(),User_Navigation.class);
                    startActivity(i);
                    finish();
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Wrong Inputs",Toast.LENGTH_LONG).show();
                }
            }
        });

    }



}
