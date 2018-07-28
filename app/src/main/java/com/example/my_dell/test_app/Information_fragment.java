package com.example.my_dell.test_app;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

public class Information_fragment extends Fragment {
    TextView show_name,show_username,show_Password;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_information,null);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        view.findViewById(R.id.Click_me).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),User_Navigation.class);
                startActivity(intent);

            }
        });

        show_name =(TextView)getView().findViewById(R.id.name_show);
        SharedPreferences sharedPreferences = this.getActivity().getSharedPreferences("MyData", Context.MODE_PRIVATE);
        String name = sharedPreferences.getString("Name","N/a");
        show_name.setText(name);
         show_username=(TextView)getView().findViewById(R.id.username_show);
        String username = sharedPreferences.getString("username","N/A");
        String password = sharedPreferences.getString("password","N/A");
        show_Password = (TextView)getView().findViewById(R.id.password_show);
        show_username.setText(username);
         show_Password.setText(password);
    }
}
