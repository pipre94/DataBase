package com.andresteran.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by pc-16 on 23/05/17.
 */

public class DataUser {

    SQLiteOpenHelper dbHelper;
    SQLiteDatabase database;


    private static final String[] allColums = {
      HelperUser.COLUMN_ID,
      HelperUser.COLUMN_NAME,
      HelperUser.COLUMN_EMAIL

    };


    public DataUser(Context context){
        dbHelper = new HelperUser(context);

    }

    public void open(){

        database = dbHelper.getWritableDatabase();
    }

    public void close(){
        dbHelper.close();
    }

    public User create(User user){
        ContentValues values = new ContentValues();
        values.put(HelperUser.COLUMN_NAME, user.getName());
        values.put(HelperUser.COLUMN_EMAIL, user.getEmail());


        long insertId = database.insert(HelperUser.TABLE_USERS, null, values);
        user.setId(insertId);

        return user;

    }

    public List<User> cursorTolis(Cursor cursor){
        List<User> users = new ArrayList<>();
        if(cursor.getCount() > 0){
            while (cursor.moveToNext()){
                User user = new User();
                User.setId(cursor.getLong(cursor.getColumnIndex(HelperUser.COLUMN_ID)));
                User.setName(cursor.getLong(cursor.getColumnIndex(HelperUser.COLUMN_NAME)));
                User.setEmail(cursor.getLong(cursor.getColumnIndex(HelperUser.COLUMN_EMAIL)));


                user.add(user);
            }
        }
        return users;
    }


    public List<User> finALl(){
        Cursor cursor = database.rawQuery("select * from users", null);
        List<User> users= cursorTolis(cursor);


        return users;

    }


}
