package com.example.my_dell.test_app;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Usersave extends AppCompatActivity {
    Button save,back;
    EditText name,username,pas1,pas2;
    String password1,password2,name1,user1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usersave);
        save=(Button)findViewById(R.id.signup);
        username=(EditText)findViewById(R.id.user1);
        pas1=(EditText)findViewById(R.id.pass1);
        pas2=(EditText)findViewById(R.id.pass2);
        back=(Button)findViewById(R.id.back);
        name=(EditText)findViewById(R.id.Name);



        OnSaveClick();
        OnBackClick();
    }
    public void OnSaveClick()
    {
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                password1 = pas1.getText().toString();
                password2 = pas2.getText().toString();
                name1=name.getText().toString();
                user1=username.getText().toString();
                if (password1.equals("")||password2.equals("")||name1.equals("")||user1.equals(""))
                {
                    Toast.makeText(getApplicationContext(),"Fields cannot be empty",Toast.LENGTH_LONG).show();
                    return;

                }

                if (password2.equals(password1)) {
                    SharedPreferences sharedPreferences = getSharedPreferences("MyData", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("username", username.getText().toString());
                    editor.putString("password", pas1.getText().toString());
                    editor.putString("Name",name.getText().toString());
                    editor.commit();
                    Toast.makeText(getApplicationContext(), "Saved Successfully", Toast.LENGTH_LONG).show();
                    Intent ji = new Intent(getApplicationContext(),MainActivity.class);
                    startActivity(ji);
                    finish();

                } else {
                    Toast.makeText(getApplicationContext(), "Password does not match", Toast.LENGTH_LONG).show();
                }
            }
    });



    }


    public void OnBackClick()
    {
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),MainActivity.class);
               // Toast.makeText(getApplicationContext(),"Back",Toast.LENGTH_SHORT).show();
            startActivity(i);
            }
        });

    }
}
