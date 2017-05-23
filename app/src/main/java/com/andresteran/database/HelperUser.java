package com.andresteran.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by pc-16 on 23/05/17.
 */

public class HelperUser extends SQLiteOpenHelper {

    private static final String LOGTAG= "LOGTAC";
    private static final String DATABASE_NAME= "users";
    private static final int DATABASE_VERSION= 1;

    public static final  String TABLE_USERS= "users";
    public static final String COLUMN_ID="id";
    public static final  String COLUMN_NAME="name";
    public static final  String COLUMN_EMAIL="email";

    public static final String TABLE_CREATE=
            "CREATE TABLE "+ TABLE_USERS + "(" +
                    COLUMN_ID +"INTEGER PRIMARY KEY AUTOINCREMENT, "+
                    COLUMN_NAME +"TEXT ,"+
                    COLUMN_ID + "TEXt" + ")";


    public  HelperUser(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLE_CREATE);
        Log.i(LOGTAG, "Tabla de usuarios Creada Correctamente");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXIST" + TABLE_USERS);
        onCreate(db);

    }
}
