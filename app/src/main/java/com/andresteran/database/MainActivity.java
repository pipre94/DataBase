package com.andresteran.database;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    Button create, listbt;
    ListView lista;
    DataUser dataUser;
    List<User> userList;
    AdapterUser adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        create=(Button) findViewById(R.id.id_btn_create);
        listbt= (Button) findViewById(R.id.id_btn_list);
        lista= (ListView) findViewById(R.id.id_btn_listusers);

        dataUser = new DataUser(this);
        dataUser.open();


        create.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                createData();
            }
        });

        listbt.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
               userList =dataUser.finALl();
                adapter=new AdapterUser(userList, getApplicationContext());
            }
        });
    }

    private void createData(){
        User user = new User();
        user.setName("Pipre94");
        user.setEmail("Pipre94@gmail.com");


        dataUser.create(user);
    }
}
