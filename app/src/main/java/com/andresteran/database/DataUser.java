package com.andresteran.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

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
}
